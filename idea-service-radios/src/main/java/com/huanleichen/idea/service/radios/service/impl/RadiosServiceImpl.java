package com.huanleichen.idea.service.radios.service.impl;

import com.huanleichen.idea.common.domain.IdeaRadio;
import com.huanleichen.idea.common.service.mapper.IdeaRadioMapper;
import com.huanleichen.idea.service.radios.service.RadiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RadiosServiceImpl implements RadiosService {
    @Autowired
    private IdeaRadioMapper ideaRadioMapper;

    @Override
    public List<IdeaRadio> selectAll() {
        //获取所有广播并返回数据
        return ideaRadioMapper.selectAll();
    }

    @Override
    public IdeaRadio selectById(Integer id) {
        //设置查询条件
        IdeaRadio ideaRadio = new IdeaRadio();
        ideaRadio.setId(id);
        //获取对象后返回
        return ideaRadioMapper.select(ideaRadio).get(0);
    }
}
