package com.data.besharp.feature_lecture.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Desending: OrderType()
}