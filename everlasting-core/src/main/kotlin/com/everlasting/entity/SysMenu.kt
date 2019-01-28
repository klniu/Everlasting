package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName


/**
 * Created by oukingtim
 */
@TableName("sys_menu")
class SysMenu : BaseModel<SysMenu>() {
    val parentId: String? = null
    val name: String? = null
    val type: String? = null
    val icon: String? = null
    val title: String? = null
    val level: Int? = null
    val order: Int? = null
}