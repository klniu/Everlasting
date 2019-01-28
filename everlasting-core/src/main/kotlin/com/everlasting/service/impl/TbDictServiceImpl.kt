package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.TbDict
import com.everlasting.mapper.TbDictMapper
import com.everlasting.service.TbDictService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbDictServiceImpl : ServiceImpl<TbDictMapper, TbDict>(), TbDictService {

    override fun findByClassCode(classCode: String) = baseMapper.selectByClassCode(classCode)
}