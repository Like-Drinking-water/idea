package com.huanleichen.idea.service.page.content.controller;

import com.huanleichen.idea.common.domain.IdeaPageContent;
import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.service.page.content.service.PageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/page/contents")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PageContentController {
    @Autowired
    private PageContentService service;

    @RequestMapping(value = "type/{type}", method = RequestMethod.GET)
    public BaseResult getByType(
            @PathVariable(value = "type") Byte type
    ) {
        //设置查询条件
        IdeaPageContent ideaPageContent = new IdeaPageContent();
        ideaPageContent.setType(type);
        //查询
        List<IdeaPageContent> data = service.select(ideaPageContent);
        //封装并放回结果
        return BaseResult.ok(data);
    }
}
