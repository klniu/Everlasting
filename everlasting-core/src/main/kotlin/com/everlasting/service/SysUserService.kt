package com.everlasting.service

import com.baomidou.mybatisplus.extension.service.IService
import com.everlasting.entity.SysUser

/**
 * Created by oukingtim
 */
interface SysUserService : IService<SysUser> {
    /**
     * 根据用户名查询用户
     * @param username
     * *
     * @return
     */
    fun findByUserName(username: String): SysUser
}