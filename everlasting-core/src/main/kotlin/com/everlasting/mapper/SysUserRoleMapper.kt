package com.everlasting.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.everlasting.entity.SysUserRole

/**
 * Created by oukingtim
 */
interface SysUserRoleMapper : BaseMapper<SysUserRole> {
    /**
     * 根据用户id查询角色id集合
     * @param userId
     * *
     * @return
     */
    fun selectRoleIdsByUserId(userId: String): List<String>
}