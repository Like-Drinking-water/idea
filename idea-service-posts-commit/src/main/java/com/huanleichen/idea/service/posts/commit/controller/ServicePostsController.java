package com.huanleichen.idea.service.posts.commit.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
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

    @ApiOperation(value = "文章提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ideaPostsPostJson", value = "文章对象", required = true, dataType = "IdeaPostsPost", paramType = "json"),
            @ApiImplicitParam(name = "optBy", value = "操作人", required = true, dataType = "String")
    })
    @RequestMapping(value = "commit", method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam(required = true) String ideaPostsPostJson,
            @RequestParam(required = true) String optBy
    ) {
        IdeaPostsPost ideaPostsPost = null;
        int reslut = 0;
        try {
             ideaPostsPost = MapperUtils.json2pojo(ideaPostsPostJson, IdeaPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //新增文章
        if (StringUtils.isBlank(ideaPostsPost.getPostGuid())) {
            reslut = postsService.insert(ideaPostsPost, optBy);
        }

        //更新文章
        else {
            reslut = postsService.update(ideaPostsPost, optBy);
        }

        //操作失败
        if (reslut == 0) {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("文章", "文章操作失败")));
        }
        //操作成功
        else {
            return BaseResult.ok("文章保存成功");
        }
    }

}
