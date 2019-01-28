package com.everlasting.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.everlasting.entity.SysMenu
import com.everlasting.mapper.SysMenuMapper
import com.everlasting.mapper.SysRoleMenuMapper
import com.everlasting.service.SysMenuService
import com.everlasting.util.MenuTreeUtil
import com.everlasting.web.vm.JsTreeVM
import com.everlasting.web.vm.TreeStateVM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysMenuServiceImpl : ServiceImpl<SysMenuMapper, SysMenu>(), SysMenuService {

    @Autowired
    private val sysRoleMenuMapper: SysRoleMenuMapper? = null

    override fun getMenuTree(roleId: String): List<JsTreeVM> {
        val treeVoList = mutableListOf<JsTreeVM>()
        val wrapper = QueryWrapper<SysMenu>()
        wrapper.orderByAsc("sys_menu.order")
        val menuList = list(wrapper)
        var menuIds = listOf<String>()
        if (!roleId.isBlank()) {
            menuIds = sysRoleMenuMapper!!.selectMenuIdsByRoleId(roleId)
        }
        for (sysMenu in menuList) {
            val jsTreeVM = JsTreeVM()
            jsTreeVM.id = sysMenu.id
            jsTreeVM.parent = if (sysMenu.parentId.isNullOrBlank()) "#" else sysMenu.parentId
            jsTreeVM.text = sysMenu.title
            jsTreeVM.icon = sysMenu.icon
            val state = TreeStateVM()
            if (menuIds.isNotEmpty() && menuIds.contains(sysMenu.id)) {
                state.selected = true
            }
            jsTreeVM.state = state
            treeVoList.add(jsTreeVM)
        }
        return treeVoList
    }

    override fun getPermissions(userId: String): Set<String> {
        val menuList = baseMapper.getPermissions(userId)
        //用户权限列表
        val permsSet = mutableSetOf<String>()
        for (perm in menuList) {
            if (perm.isBlank()) {
                continue
            }
            permsSet.addAll(Arrays.asList(*perm.trim { it <= ' ' }.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
        }
        return permsSet
    }

    override fun getMenu(userId: String) = MenuTreeUtil.getMenu(baseMapper.selectMenuByUserId(userId))!!
}