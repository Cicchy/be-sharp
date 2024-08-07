package com.data.besharp.feature_lecture.domain.usecase

data class LectureUseCases(
    val getLectures: GetLectures,
    val deleteLecture: DeleteLecture,
    val getTasks: GetTasks,
    val deleteTask: DeleteTask
)