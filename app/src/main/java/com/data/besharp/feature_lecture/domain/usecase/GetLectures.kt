package com.data.besharp.feature_lecture.domain.usecase

import com.data.besharp.feature_lecture.domain.model.Lecture
import com.data.besharp.feature_lecture.domain.repository.LectureRepository
import kotlinx.coroutines.flow.Flow

class GetLectures(
    private val repository: LectureRepository
) {
    operator fun invoke(
    ): Flow<List<Lecture>>{
        return repository.getLectures()
    }
}