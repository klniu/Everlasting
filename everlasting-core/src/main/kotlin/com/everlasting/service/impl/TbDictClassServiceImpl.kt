package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.TbDictClass
import com.everlasting.mapper.TbDictClassMapper
import com.everlasting.service.TbDictClassService
import org.springframework.stereotype.Service
/**
 * Created by oukingtim
 */
@Service
class TbDictClassServiceImpl : ServiceImpl<TbDictClassMapper, TbDictClass>(), TbDictClassService