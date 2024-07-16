package com.data.besharp.feature_lecture.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.data.besharp.domain.model.Task

@Entity
data class Lecture(
    val subject : String,
    val tasks: MutableList<Task>,
    @PrimaryKey val id: Int? = null
)
