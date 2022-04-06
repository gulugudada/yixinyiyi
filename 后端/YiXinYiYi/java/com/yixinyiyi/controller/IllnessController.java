package com.yixinyiyi.controller;

import com.yixinyiyi.service.IllnessService;
import com.yixinyiyi.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="疾病类")
@RestController
@CrossOrigin
public class IllnessController {

    @Autowired
    IllnessService illnessService;

    @PostMapping("findAllIllness")
    public Result findAllIllness(){
        return Result.ok(illnessService.findAllIllness());
    }

    @PostMapping("findIllness")
    public Result findIllness(String illnessname){
        return Result.ok(illnessService.findIllness(illnessname));
    }
}
