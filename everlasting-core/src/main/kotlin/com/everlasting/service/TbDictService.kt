package com.everlasting.service

import com.baomidou.mybatisplus.extension.service.IService
import com.everlasting.entity.TbDict

/**
 * Created by oukingtim
 */
interface TbDictService : IService<TbDict> {

    /**
     * 根据分类编号查询字典
     * @param classCode
     * *
     * @return
     */
    fun findByClassCode(classCode: String): List<TbDict>
}