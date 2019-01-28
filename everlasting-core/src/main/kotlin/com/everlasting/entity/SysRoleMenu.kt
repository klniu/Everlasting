package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_role_menu")
class SysRoleMenu() : BaseModel<SysRoleMenu>() {
    var roleId: String? = null
    var menuId: String? = null

    constructor(menuId:String):this(){
        this.menuId = menuId
    }
}