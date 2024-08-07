package com.data.besharp.feature_lecture.domain.usecase

import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.domain.repository.LectureRepository

class DeleteTask(
    val repository: LectureRepository
) {
    suspend operator fun invoke(task: Task){
        return repository.deleteTask(task)
    }
}