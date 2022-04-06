package com.yixinyiyi.controller;

import com.yixinyiyi.entity.YangSheng;
import com.yixinyiyi.service.YangShengService;
import com.yixinyiyi.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="养生类")
@RestController
@CrossOrigin
public class YangSengController {

    @Autowired
    YangShengService yangShengService;

    @PostMapping("findAllYangSheng")
    public Result findAllYangSheng(){
        return Result.ok(yangShengService.findAllYangSheng());
    }

    @PostMapping("findAllReason")
    public Result findAllReason(){
        return Result.ok().put("reason",yangShengService.findAllReason());
    }

    @PostMapping("findYangSheng")
    public Result findYangSheng(String season){
        Result result = new Result();
        YangSheng yangSheng = new YangSheng();
        yangSheng.setSeason(season);
        result.put("reason",yangShengService.findReason(season));
        result.put("image",yangShengService.findImage(season));
        result.put("yangsheng",yangShengService.findYangSheng(yangSheng));
        return result;
    }
}
