package com.todolist.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.todolist.model.Task
import com.todolist.ui.ToDoAppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen (
    viewModel: ToDoAppViewModel,
    navController: NavController,
    ){

    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Task") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        val newTask = Task(
                            id = (viewModel.tasks.size + 1).toString(),
                            title = taskTitle,
                            description = taskDescription
                        )
                        viewModel.addTask(newTask)
                        navController.popBackStack()
                    }) {
                        Text(text = "Save")
                    }
                }
            )
        }
    ){innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
        ){
            TextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text(text = "Task Title") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))

            TextField(
                value = taskDescription,
                onValueChange = { taskDescription = it },
                label = { Text(text = "Task Description") },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun AddTaskScreenPreview(){
    AddTaskScreen(
        navController = rememberNavController(),
        viewModel = ToDoAppViewModel())
}