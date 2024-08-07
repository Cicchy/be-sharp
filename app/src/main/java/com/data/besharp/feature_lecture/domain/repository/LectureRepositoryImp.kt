package com.data.besharp.feature_lecture.domain.repository

import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.data.source.LectureDao
import com.data.besharp.feature_lecture.domain.model.Lecture
import kotlinx.coroutines.flow.Flow

class LectureRepositoryImp(
    private val dao : LectureDao
): LectureRepository {
    override fun getLectures(): Flow<List<Lecture>> {
        return dao.getLectures()
    }

    override suspend fun getLectureByID(id: Int): Lecture? {
        return dao.getLectureByID(id)
    }

    override suspend fun addLecture(lecture: Lecture) {
        return dao.addLecture(lecture)
    }

    override suspend fun addTask(task: Task) {
        return dao.addTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return dao.deleteTask(task)
    }

    override suspend fun deleteLecture(lecture: Lecture) {
        return dao.deleteLecture(lecture)
    }

    override suspend fun getTasks(parentId: Int): Flow<List<Task>> {
        return dao.getTasks(parentId)
    }

    override suspend fun getTaskByID(id: Int) {
        dao.getTaskByID(id)
    }
}