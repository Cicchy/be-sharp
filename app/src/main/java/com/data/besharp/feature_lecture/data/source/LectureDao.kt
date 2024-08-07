package com.data.besharp.feature_lecture.data.source

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.domain.model.Lecture
import kotlinx.coroutines.flow.Flow

@Dao
interface LectureDao {
    //Lectures
    @Query("SELECT * FROM lecture")
    fun getLectures(): Flow<List<Lecture>>
    @Query("SELECT * FROM lecture WHERE  id = :id")
    suspend fun getLectureByID(id: Int): Lecture?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLecture(lecture: Lecture)
    @Delete
    suspend fun deleteLecture(lecture: Lecture)

    //Tasks

    @Query("SELECT * FROM lecture WHERE  id = :parentId")
    suspend fun getTasks(parentId: Int): Flow<List<Task>>
    @Query("SELECT * FROM lecture WHERE  id = :id")
    suspend fun getTaskByID(id: Int): Flow<List<Task>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: Task)
    @Delete
    suspend fun deleteTask(task: Task)

}