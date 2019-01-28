package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.SysUserRole
import com.everlasting.mapper.SysUserRoleMapper
import com.everlasting.service.SysUserRoleService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysUserRoleServiceImpl : ServiceImpl<SysUserRoleMapper, SysUserRole>() , SysUserRoleService