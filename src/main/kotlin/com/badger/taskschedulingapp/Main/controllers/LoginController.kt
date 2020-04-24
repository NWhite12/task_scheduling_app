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

    fun loginAttempt(userName: TextField, password: TextField): Boolean {
        println("attemp to long in (from login view)")
        println("name is: ${userName.text} \npassword is: ${password.text}")

        //todo: make this a real test that hits a database
        val someTest: Boolean = true

        if (someTest) {
            find<TaskListView>(mapOf(TaskListView::userName to userName.text)).openWindow(owner = null)
        } else {
            //todo: go and find an alert modle type and send her instead
            find<AlertView>(mapOf(AlertView::alert to "Faild login attemp", AlertView::message to "You hit the wrong buttons")).openWindow(owner = null)
        }

        return someTest
    }
}