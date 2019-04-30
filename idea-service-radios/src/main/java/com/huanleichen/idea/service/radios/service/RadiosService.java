package com.huanleichen.idea.service.radios.service;

import com.huanleichen.idea.common.domain.IdeaRadio;

import java.util.List;

public interface RadiosService {
    /**
     * 查看所有广播频道
     * @return
     */
    List<IdeaRadio> selectAll();

    /**
     * 根据 ID 获取对应的广播频道
     * @param id
     * @return
     */
    IdeaRadio selectById(Integer id);
}
