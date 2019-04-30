package com.huanleichen.idea.service.posts.recommend.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.huanleichen.idea.common.domain.IdeaPostsPost;
import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.common.utils.MapperUtils;
import com.huanleichen.idea.service.posts.recommend.service.PostsServiceExtend;
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
    private PostsServiceExtend postsService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sortType", value = "排序的方式(1:表示按发布时间, 2:表示按点赞人数)", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "postAdress", value = "发布地址", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "ideaSysUserJson", value = "文章对象 JSON 字符串", required = false, dataTypeClass = String.class, paramType = "json")
    })
    @RequestMapping(value = "page/{sortType}/{postAdress}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(value = "sortType") int sortType,
            @PathVariable(value = "pageNum") int pageNum,
            @PathVariable(value = "pageSize") int pageSize,
            @PathVariable(value = "postAdress") int postAdress,
            @RequestParam(required = false) String ideaPostsPostJson
    ) {
        IdeaPostsPost ideaPostsPost = new IdeaPostsPost();
        if (!StringUtils.isBlank(ideaPostsPostJson)) {
            try {
                ideaPostsPost = MapperUtils.json2pojo(ideaPostsPostJson, IdeaPostsPost.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //设置文章发布地址
        ideaPostsPost.setPostAdress(postAdress);

        //获取数据
        PageInfo<IdeaPostsPost> pageInfo = null;
        //按发布时间排序
        if (sortType == 1) {
            pageInfo = postsService.pageSortByLastTime(pageNum, pageSize, ideaPostsPost);
        }
        //按点赞人数排序
        else if (sortType == 2) {
            pageInfo = postsService.pageSortByLikeNum(pageNum, pageSize, ideaPostsPost);
        }

        BaseResult baseResult = null;
        //排序类型错误
        if (pageInfo == null) {
            //封装错误集
            baseResult = BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("排序类型", "排序类型填写错误")));
        }
        //排序类型正确
        else {
            //封装所需对象
            baseResult = BaseResult.ok(pageInfo.getList());

            BaseResult.Cursor cursor = new BaseResult.Cursor();
            cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
            cursor.setOffset(pageNum);
            cursor.setLimit(pageSize);

            baseResult.setCursor(cursor);
        }

        return baseResult;
    }

}
