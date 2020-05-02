package com.badger.taskschedulingapp.Main.controllers

import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.views.CreateTaskView
import com.badger.taskschedulingapp.Main.views.EditTaskView
import com.badger.taskschedulingapp.Main.views.WelcomeView
import tornadofx.*

class TaskListController: Controller() {


    fun CreateTask(){
        println("Opeing up the create task view (from task list )")
        find<CreateTaskView>().openWindow(owner = null)
    }

    fun Logout(){
        println("heading back to welcome view (from task list controller)")
        find<WelcomeView>().openWindow(owner = null)
    }

    fun EditTask(task: Task){
        println("opening a task in the edit view (from task list controller)")
        find<EditTaskView>(mapOf(EditTaskView::task to task)).openWindow(owner = null)
    }
}