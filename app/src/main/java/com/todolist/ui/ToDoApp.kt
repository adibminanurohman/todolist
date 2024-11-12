package com.todolist.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable // Impor ini ditambahkan
import com.todolist.ui.add.AddTaskScreen
import com.todolist.ui.detail.TaskDetailScreen
import com.todolist.ui.home.HomeScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun ToDoApp(
    viewModel: ToDoAppViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable("add") {
            AddTaskScreen(navController = navController, viewModel = viewModel)
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")
            TaskDetailScreen(
                navController = navController,
                viewModel = viewModel,
                taskId = taskId
            )
        }
    }
}
