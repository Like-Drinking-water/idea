package com.huanleichen.idea.service.sso.service.impl;

import com.huanleichen.idea.common.domain.IdeaSysUser;
import com.huanleichen.idea.common.service.mapper.IdeaSysUserMapper;
import com.huanleichen.idea.common.utils.MapperUtils;
import com.huanleichen.idea.service.sso.service.SSOService;
import com.huanleichen.idea.service.sso.service.consumer.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class SSOServiceImpl implements SSOService {
    private static final Logger logger = LoggerFactory.getLogger(SSOServiceImpl.class);

    @Autowired
    private IdeaSysUserMapper mapper;

    @Autowired
    private RedisService redisService;

    @Override
    public IdeaSysUser login(String loginCode, String password) {
        String json = redisService.get(loginCode);
        IdeaSysUser user = null;

        //缓冲中有数据
        if (json != null) {
            try {
                user = MapperUtils.json2pojo(json, IdeaSysUser.class);
            } catch (Exception e) {
                logger.warn("触发熔断: {}", e.getMessage());
                user = loginByDB(loginCode, password);
            }
        }

        //缓冲中没有数据
        else {

            user = loginByDB(loginCode, password);
        }

        return user;
    }

    private IdeaSysUser loginByDB(String loginCode, String password) {
        IdeaSysUser user = null;

        Example example = new Example(IdeaSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        user = mapper.selectOneByExample(example);
        if (user != null) {
            //密码不正确
            if (!user.getPassword().equals(password)) {
                user = null;
            }
            //密码正确
            else {
                try {
                    redisService.put(loginCode, MapperUtils.obj2json(user), 60 * 60 * 24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
