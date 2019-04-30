package com.huanleichen.idea.service.posts.recommend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanleichen.idea.common.domain.IdeaPostsPost;
import com.huanleichen.idea.common.service.mapper.IdeaPostsPostMapper;
import com.huanleichen.idea.common.service.service.impl.BaseServiceImpl;
import com.huanleichen.idea.service.posts.recommend.service.PostsServiceExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostsServiceExtendImpl extends BaseServiceImpl<IdeaPostsPost, IdeaPostsPostMapper> implements PostsServiceExtend {

    @Override
    public PageInfo<IdeaPostsPost> pageSortByLastTime(int pageNum, int pageSize, IdeaPostsPost ideaPostsPost) {
        //获取数据后将数据进行排序
        List<IdeaPostsPost> data = selectAndSort(ideaPostsPost, new Comparator<IdeaPostsPost>() {
            @Override
            public int compare(IdeaPostsPost o1, IdeaPostsPost o2) {
                return o2.getTimePublished().compareTo(o1.getTimePublished());
            }
        });
        //将数据打包后返回
        return page(pageNum, pageSize, data);
    }

    @Override
    public PageInfo<IdeaPostsPost> pageSortByLikeNum(int pageNum, int pageSize, IdeaPostsPost ideaPostsPost) {
        //获取数据后将数据进行排序
        List<IdeaPostsPost> data = selectAndSort(ideaPostsPost, new Comparator<IdeaPostsPost>() {
            @Override
            public int compare(IdeaPostsPost o1, IdeaPostsPost o2) {
                return o2.getLikeNum() - o1.getLikeNum();
            }
        });
        //将数据打包后返回
        return page(pageNum, pageSize, data);
    }

    private PageInfo<IdeaPostsPost> page(int pageNum, int pageSize, List<IdeaPostsPost> data) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum, pageSize);

        PageInfo<IdeaPostsPost> pageInfo = new PageInfo(data);
        return pageInfo;
    }

    private List<IdeaPostsPost> selectAndSort(IdeaPostsPost ideaPostsPost, Comparator<IdeaPostsPost> comparator) {
        List<IdeaPostsPost> data = dao.select(ideaPostsPost);
        data.sort(comparator);
        return data;
    }
}
