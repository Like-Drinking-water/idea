package com.huanleichen.idea.service.posts.recommend.service;


import com.github.pagehelper.PageInfo;
import com.huanleichen.idea.common.domain.IdeaPostsPost;
import com.huanleichen.idea.common.service.service.BaseService;

public interface PostsServiceExtend extends BaseService<IdeaPostsPost> {
    /**
     * 根据发布时间进行排序分页
     * @param pageNum 页数
     * @param pageSize 每页容量
     * @param ideaPostsPost 查询条件
     * @return
     */
    PageInfo<IdeaPostsPost> pageSortByLastTime(int pageNum, int pageSize, IdeaPostsPost ideaPostsPost);

    /**
     * 根据点赞的人数进行排序分页
     * @param pageNum
     * @param pageSize
     * @param ideaPostsPost
     * @return
     */
    PageInfo<IdeaPostsPost> pageSortByLikeNum(int pageNum, int pageSize, IdeaPostsPost ideaPostsPost);
}
