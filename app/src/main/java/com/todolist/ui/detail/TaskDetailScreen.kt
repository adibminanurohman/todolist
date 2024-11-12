package com.todolist.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.todolist.ui.ToDoAppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen (
    viewModel: ToDoAppViewModel,
    navController: NavController,
    taskId: String?
){
    val task = viewModel.getTaskById(taskId)
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text(text = task?.title ?: "")},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        viewModel.deleteTask(task?.id)
                        navController.popBackStack()
                    }) {
                        Text(text = "Delete")
                    }
                }
            )
        }
    ){innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){
            Text(
                text = task?.description ?: "",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                )
        }

    }
}

@Preview
@Composable
fun TaskDetailScreenPreview(){
    TaskDetailScreen(
        navController = rememberNavController(),
        viewModel = ToDoAppViewModel(), taskId = "2")
}