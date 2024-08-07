package com.data.besharp.feature_lecture.presentation.lectures

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.besharp.domain.model.Task
import com.data.besharp.feature_lecture.domain.usecase.LectureUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LecturesViewModel @Inject constructor(
    private val  lectureUseCases: LectureUseCases
): ViewModel(){
    private val _taskstate = mutableStateOf(TaskState())
    val state : State<TaskState> = _taskstate

    private var recentlyDeletedTask: Task? = null
    private var getLecturesJob: Job?=null
    init{
        getLectures()
    }

    private fun getLectures(){
        getLecturesJob?.cancel()
        getLecturesJob = lectureUseCases.getLectures()
            .onEach {lectures ->

        }.launchIn(viewModelScope)
    }

}