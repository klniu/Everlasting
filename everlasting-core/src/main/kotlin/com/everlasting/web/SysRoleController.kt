package com.oukingtim.web

import com.everlasting.entity.SysRole
import com.everlasting.service.SysRoleService
import com.everlasting.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/role")
class SysRoleController : BaseController<SysRoleService, SysRole>() {

    /**
     * 获取角色集合
     */
    @GetMapping("/getlist")
    fun getList(@RequestParam(required = false) userId: String) = ResultVM.ok(service!!.getList(userId))

}