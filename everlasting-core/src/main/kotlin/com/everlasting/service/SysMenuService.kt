package com.everlasting.service

import com.baomidou.mybatisplus.extension.service.IService
import com.everlasting.entity.SysMenu
import com.everlasting.web.vm.JsTreeVM
import com.everlasting.web.vm.MenuVM

/**
 * Created by oukingtim
 */
interface SysMenuService : IService<SysMenu> {
    /**
     * 根据角色id获取菜单树
     * @param roleId
     * *
     * @return
     */
    fun getMenuTree(roleId: String): List<JsTreeVM>

    /**
     * 根据用户id获取权限集合
     * @param userId
     * *
     * @return
     */
    fun getPermissions(userId: String): Set<String>

    /**
     * 根据用户id获取菜单
     * @param userId
     * *
     * @return
     */
    fun getMenu(userId: String): List<MenuVM>
}