package com.badger.taskschedulingapp.Main.controllers

import com.badger.taskschedulingapp.Main.views.AlertView
import com.badger.taskschedulingapp.Main.views.TaskListView
import com.badger.taskschedulingapp.Main.views.WelcomeView
import javafx.scene.control.TextField
import tornadofx.*

class LoginController: Controller() {

    fun cancelLogin(){
        println("Open the Welcome view (from Login view)")
        find<WelcomeView>().openWindow(owner = null)
    }

    fun loginAttempt(userName: TextField, password: TextField){
        println("attemp to long in (from login view)")
        println("name is: ${userName.text} \npassword is: ${password.text}")

        //todo: add if statment to check if allowed in database
        //todo: add else to open up popup window saying failed

        //find<TaskListView>(mapOf(TaskListView::userName to userName.text)).openWindow(owner = null)
        find<AlertView>(mapOf(AlertView::alert to "Faild login attemp", AlertView::message to "You hit the wrong buttons")).openWindow(owner = null)
    }
}