package com.whb.controller;

import com.whb.entity.Enterprise;
import com.whb.entity.Result;
import com.whb.entity.StatusCode;
import com.whb.service.EnterpriseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation("搜索热门企业")
    @GetMapping("/search/hot")
    public Result<List<Enterprise>> searchHot() {
        List<Enterprise> list = enterpriseService.search();
        return new Result(true, StatusCode.OK,"搜索成功", list);
    }
}
