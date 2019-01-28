package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.SysRoleMenu
import com.everlasting.mapper.SysRoleMenuMapper
import com.everlasting.service.SysRoleMenuService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysRoleMenuServiceImpl : ServiceImpl<SysRoleMenuMapper, SysRoleMenu>() , SysRoleMenuService