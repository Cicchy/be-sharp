package com.data.besharp.feature_lecture.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.data.besharp.domain.model.Task

@Entity
data class Lecture(
    val subject : String,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val lectureColors = listOf(
            Color.Blue,
        )
    }
}