package com.whb.controller;


import com.whb.entity.Label;
import com.whb.entity.PageResult;
import com.whb.entity.Result;
import com.whb.entity.StatusCode;
import com.whb.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
@Api(tags = {"标签"})
public class LabelController {


    @Autowired
    private LabelService labelService;

    @ApiOperation("添加标签")
    @PostMapping("add")
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    @ApiOperation("标签全部列表")
    @GetMapping()
    public Result<List<Label>> list() {
        List<Label> list = labelService.list();
        return new Result(true, StatusCode.OK,"查询成功", list);
    }

    @ApiOperation("推荐标签列表")
    @GetMapping("/topList")
    public Result<List<Label>> topList() {
        List<Label> list = labelService.topList();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation("修改标签")
    @PutMapping("/{id}")
    public Result update(@RequestBody Label label, @PathVariable("id") String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation("删除标签")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        labelService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/{id}")
    public Result<Label> findById(@PathVariable("id") String id) {
        Label label = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @ApiOperation("条件查询")
    @PostMapping("/search")
    public Result<List<Label>> search(@RequestBody Label label) {
        List<Label> list= labelService.search(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation("条件查询")
    @PostMapping("/searchPage/{page}/{size}")
    public Result<List<Label>> searchPage(@RequestBody Label label,@PathVariable int page,@PathVariable int size) {
        Page<Label> pages = labelService.searchPage(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pages.getTotalElements(),pages.getContent()));
    }
}
