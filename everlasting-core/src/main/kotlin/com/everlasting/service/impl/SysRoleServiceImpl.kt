package com.oukingtim.service.impl

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.SysRole
import com.everlasting.entity.SysRoleMenu
import com.everlasting.mapper.SysRoleMapper
import com.everlasting.mapper.SysRoleMenuMapper
import com.everlasting.mapper.SysUserRoleMapper
import com.everlasting.service.SysRoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysRoleServiceImpl : ServiceImpl<SysRoleMapper, SysRole>(), SysRoleService {

    @Autowired
    private val sysUserRoleMapper: SysUserRoleMapper? = null

    @Autowired
    private val sysRoleMenuMapper: SysRoleMenuMapper? = null

    override fun getList(userId: String): List<SysRole> {
        val roleList = selectList(EntityWrapper<SysRole>())
        if (!userId.isNullOrBlank()) {
            val list = sysUserRoleMapper!!.selectRoleIdsByUserId(userId)
            for (role in roleList) {
                if (list.contains(role.id)) {
                    role.checked=true
                }
            }
        }
        return roleList
    }

    override fun insert(entity: SysRole): Boolean {
        val flag = super.insert(entity)
        for (jsTreeVM in entity.menuTree!!) {
            val sysRoleMenu = SysRoleMenu()
            sysRoleMenu.roleId=entity.id
            sysRoleMenu.menuId=jsTreeVM.id
            sysRoleMenuMapper!!.insert(sysRoleMenu)
        }
        return flag
    }

    override fun updateById(entity: SysRole): Boolean {
        val flag = super.updateById(entity)
        val roleMenu = SysRoleMenu()
        roleMenu.roleId=entity.id
        sysRoleMenuMapper!!.delete(EntityWrapper(roleMenu))
        for (jsTreeVM in entity.menuTree!!) {
            val sysRoleMenu = SysRoleMenu()
            sysRoleMenu.roleId=entity.id
            sysRoleMenu.menuId=jsTreeVM.id
            sysRoleMenuMapper!!.insert(sysRoleMenu)
        }
        return flag
    }
}