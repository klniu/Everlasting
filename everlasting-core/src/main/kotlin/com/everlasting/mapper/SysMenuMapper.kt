package com.everlasting.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.everlasting.entity.SysMenu

/**
 * Created by oukingtim
 */
interface SysMenuMapper : BaseMapper<SysMenu> {

    /**
     * 根据用户id获取菜单
     * @param userId
     * *
     * @return
     */
    fun selectMenuByUserId(userId: String): List<SysMenu>

    /**
     * 根据用户id查询权限
     * @param userId
     * *
     * @return
     */
    fun getPermissions(userId: String): List<String>
}