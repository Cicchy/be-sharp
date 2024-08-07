package com.data.besharp.feature_lecture.domain.util

import com.data.besharp.domain.model.TaskState

sealed class TaskOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): TaskOrder(orderType)
    class State(orderType: OrderType, val state: TaskState): TaskOrder(orderType)
    class DeadLine(orderType: OrderType): TaskOrder(orderType)
    class Performance(orderType: OrderType): TaskOrder(orderType)
}