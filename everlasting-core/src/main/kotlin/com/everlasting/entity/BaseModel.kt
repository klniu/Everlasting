package com.everlasting.entity

import java.io.Serializable
import java.util.*

/**
 * 通用实体（通用字段）
 * Created by oukingtim
 */
abstract class BaseModel<T> {

    val id: String? = null

    var createUserId: String? = null

    var createTime: Date? = null

    var updateUserId: String? = null

    var updateTime: Date? = null

    protected fun pkVal(): Serializable {
        // TODO Auto-generated method stub
        return id!!
    }
}