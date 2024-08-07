package com.data.besharp.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.data.besharp.feature_lecture.domain.model.Lecture
import java.time.LocalDateTime
@Entity(
    foreignKeys = [ForeignKey(
        entity = Lecture::class,
        parentColumns = ["id"],
        childColumns = ["parentID"],
        onDelete = ForeignKey.CASCADE
    )]
)
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
    val parentID : Int? = null,
    @PrimaryKey val id: Int? = null
)