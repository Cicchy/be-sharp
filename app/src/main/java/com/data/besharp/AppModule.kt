package com.data.besharp

import android.app.Application
import androidx.room.Room
import com.data.besharp.feature_lecture.data.source.LectureDB
import com.data.besharp.feature_lecture.domain.repository.LectureRepository
import com.data.besharp.feature_lecture.domain.repository.LectureRepositoryImp
import com.data.besharp.feature_lecture.domain.usecase.DeleteLecture
import com.data.besharp.feature_lecture.domain.usecase.DeleteTask
import com.data.besharp.feature_lecture.domain.usecase.GetLectures
import com.data.besharp.feature_lecture.domain.usecase.GetTasks
import com.data.besharp.feature_lecture.domain.usecase.LectureUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLectureDatabase(app: Application): LectureDB{
        return Room.databaseBuilder(
            app,
            LectureDB::class.java,
            LectureDB.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideLectureRepo(db: LectureDB) : LectureRepository{
        return LectureRepositoryImp(db.lectureDao)
    }

    fun provideLectureUsecases(repository: LectureRepository): LectureUseCases{
        return LectureUseCases(
            getLectures = GetLectures(repository),
            deleteLecture = DeleteLecture(repository),
            getTasks = GetTasks(repository),
            deleteTask = DeleteTask(repository)
        )
    }
}