package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.everlasting.entity.TbTodo
import com.everlasting.mapper.TbTodoMapper
import com.everlasting.service.TbTodoService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbTodoServiceImpl : ServiceImpl<TbTodoMapper, TbTodo>(), TbTodoService