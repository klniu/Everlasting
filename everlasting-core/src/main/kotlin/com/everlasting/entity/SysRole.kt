package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.everlasting.web.vm.JsTreeVM

/**
 * Created by oukingtim
 */
@TableName("sys_role")
class SysRole() : BaseModel<SysRole>() {

    var roleName: String? = null
    val remark: String? = null
    @TableField(exist = false)
    var checked: Boolean? = null
    @TableField(exist = false)
    val menuTree: List<JsTreeVM>? = null

    constructor(roleName: String):this(){
        this.roleName = roleName
    }
}