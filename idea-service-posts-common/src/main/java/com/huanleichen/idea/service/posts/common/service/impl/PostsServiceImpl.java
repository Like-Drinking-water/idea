package com.huanleichen.idea.service.posts.common.service.impl;

import com.huanleichen.idea.common.domain.IdeaPostsPost;
import com.huanleichen.idea.common.service.mapper.IdeaPostsPostMapper;
import com.huanleichen.idea.common.service.service.impl.BaseServiceImpl;
import com.huanleichen.idea.service.posts.common.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<IdeaPostsPost, IdeaPostsPostMapper> implements PostsService {
}
