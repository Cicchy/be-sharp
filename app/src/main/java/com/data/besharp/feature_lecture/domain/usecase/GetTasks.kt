package com.data.besharp.feature_lecture.domain.usecase

import com.data.besharp.domain.model.Task
import com.data.besharp.domain.model.TaskState
import com.data.besharp.feature_lecture.domain.repository.LectureRepository
import com.data.besharp.feature_lecture.domain.util.OrderType
import com.data.besharp.feature_lecture.domain.util.TaskOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTasks(
    private val repository: LectureRepository
) {
    suspend operator fun invoke(
        id: Int,
        taskOrder: TaskOrder = TaskOrder.DeadLine(orderType = OrderType.Desending)
    ): Flow<List<Task>>{
        return repository.getTasks(id).map { lectures ->
            when (taskOrder.orderType){
                is OrderType.Ascending -> {
                    when (taskOrder){
                        is TaskOrder.Title -> lectures.sortedBy { it.title }
                        is TaskOrder.State -> lectures.filter {it.state == taskOrder.state }
                        is TaskOrder.DeadLine -> lectures.sortedBy { it.deadLine }
                        is TaskOrder.Performance -> lectures.sortedBy { it.performance }
                    }
                }

                is OrderType.Desending -> {
                    when (taskOrder){
                        is TaskOrder.Title -> lectures.sortedByDescending { it.title }
                        is TaskOrder.State -> lectures.filter {it.state == taskOrder.state }
                        is TaskOrder.DeadLine -> lectures.sortedByDescending { it.deadLine }
                        is TaskOrder.Performance -> lectures.sortedByDescending { it.performance }
                    }
                }
            }
        }
    }
}