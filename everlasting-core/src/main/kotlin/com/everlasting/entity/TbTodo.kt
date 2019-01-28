package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_todo")
class TbTodo : BaseModel<TbTodo>() {
    var text: String? = null
}