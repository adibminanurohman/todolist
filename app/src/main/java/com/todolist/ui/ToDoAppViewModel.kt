package com.todolist.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.todolist.model.Task

class ToDoAppViewModel: ViewModel() {
    private val _tasks = mutableStateListOf(
        Task("1", "Task 1"),
        Task("2", "Task 2", "Mengerjakan pekerjaan rumah"),
        Task("3", "Task 3", "Mengerjakan tugas kuliah"),
    )

    val tasks: List<Task> get() = _tasks

    fun addTask(task: Task) {
        _tasks.add(task)
    }

    fun deleteTask(taskId: String?) {
        _tasks.removeAll{it.id == taskId}
    }

    fun getTaskById(taskId: String?): Task? {
        return _tasks.find { it.id == taskId }

    }
}