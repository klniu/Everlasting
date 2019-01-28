package com.everlasting.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_user_role")
class SysUserRole : BaseModel<SysUserRole>() {
    var roleId: String? = null
    var userId: String? = null
}