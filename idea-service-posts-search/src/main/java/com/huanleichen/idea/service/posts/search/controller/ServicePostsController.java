package com.huanleichen.idea.service.posts.search.controller;

import com.github.pagehelper.PageInfo;
import com.huanleichen.idea.common.domain.IdeaPostsPost;
import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.common.utils.MapperUtils;
import com.huanleichen.idea.service.posts.common.service.PostsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("v1/posts")
public class ServicePostsController {

    @Autowired
    private PostsService postsService;

    @ApiOperation(value = "文章查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postGuid", value = "文章编号", required = true, dataType = "String", paramType = "path")
    })
    @RequestMapping(value = "{postGuid}", method = RequestMethod.GET)
    public BaseResult get(
          @PathVariable(value = "postGuid") String postGuid
    ) {
        //设置查询条件
        IdeaPostsPost ideaPostsPost = new IdeaPostsPost();
        ideaPostsPost.setPostGuid(postGuid);
        //获取对象
        IdeaPostsPost obj = postsService.selectOne(ideaPostsPost);
        //将对象封装成所需格式并返回
        return BaseResult.ok(obj);
    }
}
