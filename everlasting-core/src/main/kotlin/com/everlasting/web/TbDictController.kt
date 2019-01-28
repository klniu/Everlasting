package com.oukingtim.web

import com.everlasting.entity.TbDict
import com.everlasting.service.TbDictService
import com.everlasting.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/dict")
class TbDictController : BaseController<TbDictService, TbDict>() {

    /**
     * 根据分类编号获取字典
     * @param code
     * @return
     */
    @GetMapping("/getlist/{code}")
    fun getList(@PathVariable code: String) = ResultVM.ok(service!!.findByClassCode(code))

}