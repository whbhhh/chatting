package com.whb.controller;


import com.whb.entity.Recruit;
import com.whb.entity.Result;
import com.whb.entity.StatusCode;
import com.whb.service.RecruitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @ApiOperation("查询状态为2  创建日期倒叙排序 前4条")
    @GetMapping("/search/recommend")
    public Result<List<Recruit>> findTop4ByState() {
        List<Recruit> list = recruitService.findTop4ByState();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation("查询状态不为0  创建日期倒叙排序 前12条")
    @GetMapping("/search/newlist")
    public Result<List<Recruit>> findTop12ByStateNot() {
        List<Recruit> list = recruitService.findTop12ByStateNot();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }
}
