package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Category;

import java.util.List;

/**
 * TODO
 *
 * @author ErenPC
 * @version 1.0
 */
public interface CategoryService extends IService<Category> {

    /**
     * 根据父ID查询子分类
     */
    List<Category> queryByParentId(Integer pid);
}
