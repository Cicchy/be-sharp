package com.data.besharp.feature_lecture.domain.repository

import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.domain.model.Lecture
import kotlinx.coroutines.flow.Flow

interface LectureRepository {
    //Lectures
    fun getLectures(): Flow<List<Lecture>>
    suspend fun getLectureByID(id: Int): Lecture?
    suspend fun addLecture(lecture: Lecture)
    suspend fun deleteLecture(lecture: Lecture)

    //Task
    suspend fun getTasks(parentId: Int): Flow<List<Task>>
    suspend fun getTaskByID(id: Int)
    suspend fun addTask(task: Task)
    suspend fun deleteTask(task: Task)
}