package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_dict_class")
class TbDictClass : BaseModel<TbDictClass>() {
    val code: String? = null
    val remark: String? = null
}