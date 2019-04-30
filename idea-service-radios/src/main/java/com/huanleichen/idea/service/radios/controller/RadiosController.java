package com.huanleichen.idea.service.radios.controller;

import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.service.radios.service.RadiosService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "v1/radios")
public class RadiosController {
    @Autowired
    private RadiosService radiosService;

    @ApiOperation(value = "获取所有广播频道")
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public BaseResult getAll() {
        return BaseResult.ok(radiosService.selectAll());
    }

    @ApiOperation(value = "获取单个广播频道")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "广播编号", required = true, dataType = "int", paramType = "path")
    })
    @RequestMapping(value = "radio/{id}", method = RequestMethod.GET)
    public BaseResult getOne(
            @PathVariable(value = "id") Integer id
    ) {
        return BaseResult.ok(radiosService.selectById(id));
    }
}
