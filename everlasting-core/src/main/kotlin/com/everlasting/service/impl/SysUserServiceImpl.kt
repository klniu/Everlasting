package com.oukingtim.service.impl

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.SysUser
import com.everlasting.entity.SysUserRole
import com.everlasting.mapper.SysUserMapper
import com.everlasting.mapper.SysUserRoleMapper
import com.everlasting.service.SysUserService
import org.apache.shiro.crypto.hash.Sha256Hash
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysUserServiceImpl : ServiceImpl<SysUserMapper, SysUser>(), SysUserService {

    @Autowired
    private val sysUserRoleMapper: SysUserRoleMapper? = null

    override fun insert(entity: SysUser): Boolean {
        val password = Sha256Hash(entity.password).toHex()
        entity.password = password
        val flag = super.insert(entity)
        if (entity.rolelist!!.isNotEmpty()) {
            for (role in entity.rolelist!!) {
                if (role.checked != null && role.checked!!) {
                    val sysUserRole = SysUserRole()
                    sysUserRole.userId = entity.id
                    sysUserRole.roleId = role.id
                    sysUserRoleMapper!!.insert(sysUserRole)
                }
            }
        }
        return flag
    }

    override fun updateById(entity: SysUser): Boolean {
        val flag = super.updateById(entity)
        val userRole = SysUserRole()
        userRole.userId = entity.id
        if (entity.rolelist!!.isNotEmpty()) {
            sysUserRoleMapper!!.delete(EntityWrapper(userRole))
            for (role in entity.rolelist!!) {
                if (role.checked != null && role.checked!!) {
                    val sysUserRole = SysUserRole()
                    sysUserRole.userId = entity.id
                    sysUserRole.roleId = role.id
                    sysUserRoleMapper!!.insert(sysUserRole)
                }
            }
        }
        return flag
    }

    override fun findByUserName(username: String): SysUser {
        val list = selectList(EntityWrapper(SysUser(username)))
        if (list != null && list.size > 0) {
            return list[0]
        }
        return null!!
    }
}