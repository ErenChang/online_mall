package com.gupaoedu.vip.mall.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Category;
import com.gupaoedu.vip.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author ErenPC
 * @version 1.0
 */
@RestController
@RequestMapping("/Category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父id查询子类
     */
    @GetMapping("/parent/{pid}")
    public RespResult<List<Category>> list(@PathVariable("pid") Integer pid) {
        return RespResult.ok(categoryService.queryByParentId(pid));
    }

}
