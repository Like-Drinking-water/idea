package com.huanleichen.idea.service.page.content.service.impl;

import com.huanleichen.idea.common.domain.IdeaPageContent;
import com.huanleichen.idea.common.service.mapper.IdeaPageContentMapper;
import com.huanleichen.idea.common.service.service.impl.BaseServiceImpl;
import com.huanleichen.idea.service.page.content.service.PageContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageContentServiceImpl extends BaseServiceImpl<IdeaPageContent, IdeaPageContentMapper>
        implements PageContentService {
    @Override
    public List<IdeaPageContent> select(IdeaPageContent ideaPageContent) {
        return dao.select(ideaPageContent);
    }
}
