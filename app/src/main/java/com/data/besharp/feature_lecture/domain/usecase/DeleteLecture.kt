package com.data.besharp.feature_lecture.domain.usecase

import com.data.besharp.feature_lecture.domain.model.Lecture
import com.data.besharp.feature_lecture.domain.repository.LectureRepository

class DeleteLecture(
    private val repository: LectureRepository
)  {
    suspend operator fun invoke(lecture: Lecture){
        repository.deleteLecture(lecture)
    }
}