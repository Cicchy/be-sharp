package com.data.besharp.feature_lecture.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.besharp.feature_lecture.domain.model.Lecture

@Database(
    entities = [Lecture::class],
    version = 1
)
abstract class LectureDB: RoomDatabase() {
    abstract val lectureDao: LectureDao
    companion object{
        const val DATABASE_NAME = "lectures_DB"
    }
}
