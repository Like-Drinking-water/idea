package com.huanleichen.idea.common.service.mapper;

import com.huanleichen.idea.common.domain.IdeaPageContent;
import com.huanleichen.idea.common.service.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
@CacheNamespace(implementation = RedisCache.class)
public interface IdeaPageContentMapper extends MyMapper<IdeaPageContent> {
}