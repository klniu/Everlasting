package com.everlasting.service

import com.baomidou.mybatisplus.extension.service.IService
import com.everlasting.entity.SysRole

/**
 * Created by oukingtim
 */
interface SysRoleService : IService<SysRole> {
    /**
     * 根据用户id查询角色集合
     * @param userId
     * *
     * @return
     */
    fun getList(userId: String): List<SysRole>
}