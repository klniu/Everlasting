package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.TbCalendar
import com.everlasting.mapper.TbCalendarMapper
import com.everlasting.service.TbCalendarService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbCalendarServiceImpl : ServiceImpl<TbCalendarMapper, TbCalendar>() , TbCalendarService