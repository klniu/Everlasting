package com.everlasting.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.everlasting.entity.TbDict

/**
 * Created by oukingtim
 */
interface TbDictMapper : BaseMapper<TbDict> {
    /**
     * 根据分类编号查询字典数据
     * @param classCode
     * *
     * @return
     */
    fun selectByClassCode(classCode: String): List<TbDict>
}