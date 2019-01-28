package com.everlasting.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.everlasting.entity.SysRoleMenu

/**
 * Created by oukingtim
 */
interface SysRoleMenuMapper : BaseMapper<SysRoleMenu> {
    /**
     * 根据角色id查询菜单id
     * @param roleId
     * *
     * @return
     */
    fun selectMenuIdsByRoleId(roleId: String): List<String>
}