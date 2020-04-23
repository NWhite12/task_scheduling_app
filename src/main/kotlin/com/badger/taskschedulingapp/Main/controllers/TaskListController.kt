package com.badger.taskschedulingapp.Main.controllers

import com.badger.taskschedulingapp.Main.views.WelcomeView
import tornadofx.*

class TaskListController: Controller() {


    fun Logout(){
        println("heading back to welcome view (from task list controller)")
        find<WelcomeView>().openWindow(owner = null)
    }
}