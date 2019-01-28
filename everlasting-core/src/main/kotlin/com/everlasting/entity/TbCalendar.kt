package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_calendar")
class TbCalendar : BaseModel<TbCalendar>() {
    val title: String? = null
    val start: String? = null
    val end: String? = null
    val color: String? = null
}