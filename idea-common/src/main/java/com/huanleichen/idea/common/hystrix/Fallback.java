package com.huanleichen.idea.common.hystrix;

import com.google.common.collect.Lists;
import com.huanleichen.idea.common.contants.HttpStatusContants;
import com.huanleichen.idea.common.dto.BaseResult;
import com.huanleichen.idea.common.utils.MapperUtils;

public class Fallback {
    public static String badGateway() {
        try {
            return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error(
                            String.valueOf(HttpStatusContants.BAD_GATEWAY.getStatus()),
                            HttpStatusContants.BAD_GATEWAY.getContent())
            )));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
