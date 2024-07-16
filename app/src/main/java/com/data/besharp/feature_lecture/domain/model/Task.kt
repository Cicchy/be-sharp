package com.data.besharp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
@Entity
enum class TaskState{
    PENDENT,
    COMPLETED,
    HANDED_IN,
    APPROVED,
    FAILED
}
data class Task(
    val title : String,
    val state : TaskState,
    val deadLine: LocalDateTime,
    val performance : Int? = null,
    @PrimaryKey val id: Int? = null
)