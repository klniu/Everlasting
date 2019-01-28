package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.everlasting.entity.TbCalendar
import com.everlasting.service.TbCalendarService
import com.everlasting.util.ShiroUtils
import com.everlasting.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/calendar")
class TbCalendarController : BaseController<TbCalendarService, TbCalendar>(){

    @GetMapping("/getlist")
    fun getList(): ResultVM {
        val calendar = TbCalendar()
        calendar.createUserId= ShiroUtils.getUserId()
        val list = service!!.selectList(EntityWrapper(calendar))
        return ResultVM.ok(list)
    }
}