package com.data.besharp.feature_lecture.presentation.lectures

import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.domain.util.OrderType
import com.data.besharp.feature_lecture.domain.util.TaskOrder

data class TaskState(
    val tasks : List<Task> = emptyList(),
    val taskOrder: TaskOrder = TaskOrder.DeadLine(OrderType.Desending),
    val isOrderSelectionVisible: Boolean = false
)