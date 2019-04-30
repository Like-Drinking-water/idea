package com.huanleichen.idea.service.sso.controller;

import com.google.common.collect.Lists;
import com.huanleichen.idea.common.domain.IdeaSysUser;
import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.common.utils.CookieUtils;
import com.huanleichen.idea.common.utils.MapperUtils;
import com.huanleichen.idea.service.sso.service.SSOService;
import com.huanleichen.idea.service.sso.service.consumer.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "v1/users")
public class SSOController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private SSOService service;

    @RequestMapping(value = "login/{loginCode}/{password}", method = RequestMethod.GET)
    public BaseResult login(@PathVariable(value = "loginCode") String loginCode,
                            @PathVariable(value = "password") String password,
                        HttpServletRequest request, HttpServletResponse response) {
        IdeaSysUser user = service.login(loginCode, password);

        //登录成功
        if (user != null) {
            String token = UUID.randomUUID().toString();
            String result = redisService.put(token, loginCode, 60 * 60 * 24);
            if ("Ok".equals(result)) {
                CookieUtils.setCookie(request, response, "token", token);
                return BaseResult.ok(user, "登录成功");
            } else {
                return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("服务器", "服务器连接错误，请稍后再试")));
            }

        }

        //登录失败
        else {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("登录", "用户名或密码错误")));
        }

    }

    @RequestMapping(value = "isLogin/{token}", method = RequestMethod.GET)
    public BaseResult isLogin(
            @PathVariable(value = "token") String token
    ) {
        IdeaSysUser ideaSysUser = null;
        //通过 token 从 redis 中获取登录通行证
        String loginCode = redisService.get(token);
        //获取成功再通过登录通行证获取对应的用户信息
        if (!StringUtils.isBlank(loginCode)) {
            String userJson = redisService.get(loginCode);
            //获取成功
            if (userJson != null) {
                try {
                    ideaSysUser = MapperUtils.json2pojo(userJson, IdeaSysUser.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (ideaSysUser != null) {
            return BaseResult.ok(ideaSysUser, "已登录");
        }
        else {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("用户", "用户未登录")));
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public BaseResult logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "token");
        return BaseResult.ok("成功注销");
    }
}
