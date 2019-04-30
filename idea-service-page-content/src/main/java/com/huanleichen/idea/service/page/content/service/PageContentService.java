package com.huanleichen.idea.service.page.content.service;

import com.huanleichen.idea.common.domain.IdeaPageContent;
import com.huanleichen.idea.common.service.service.BaseService;

import java.util.List;

public interface PageContentService extends BaseService<IdeaPageContent> {
    List<IdeaPageContent> select(IdeaPageContent ideaPageContent);
}
