package com.oukingtim.web

import com.everlasting.entity.SysUser
import com.everlasting.service.SysUserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/users")
class SysUserController : BaseController<SysUserService, SysUser> ()