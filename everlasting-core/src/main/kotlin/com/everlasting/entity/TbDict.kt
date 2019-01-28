package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_dict")
class TbDict : BaseModel<TbDict>() {
    val code: String? = null
    val text: String? = null
    val remark: String? = null
    val dictClassId: String? = null
}