package com.badger.taskschedulingapp.Main.controllers

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.views.CreateTaskView
import com.badger.taskschedulingapp.Main.views.EditTaskView
import com.badger.taskschedulingapp.Main.views.WelcomeView
import javafx.collections.ObservableList
import tornadofx.*

class TaskListController(u: User): Controller() {
    val user = u

    fun CreateTask(taskList: ObservableList<Task>){
        println("Opening the create task view (from task list )")
        find<CreateTaskView>(mapOf(CreateTaskView::user to user, CreateTaskView::taskList to taskList)).openWindow(owner = null)
    }

    fun Logout(){
        println("heading back to welcome view (from task list controller)")
        find<WelcomeView>().openWindow(owner = null)
    }

    fun EditTask(task: Task, taskList: ObservableList<Task>){
        println("opening a task in the edit view (from task list controller)")
        find<EditTaskView>(mapOf(EditTaskView::task to task, EditTaskView::taskList to taskList)).openWindow(owner = null)
    }
}