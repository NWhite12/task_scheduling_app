package com.badger.taskschedulingapp.Main.controllers

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.services.UserService
import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService
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
        var user = User()

        println("attempt to long in (from login view)")
        println("name is: ${userName.text} \npassword is: ${password.text}")

        if(userName.text == "" || password.text == "") find<AlertView>(mapOf(AlertView::alert to "Failed login attempt", AlertView::message to "Enter a Username and Password")).openWindow(owner = null)
        else {
            var service = UserPostgresService()
            user = service.findByUserName(userName.text)
        }

        //todo: check up on bad login after Nick adds null returns
        if (user.id != null) {
            find<TaskListView>(mapOf(TaskListView::user to user)).openWindow(owner = null)
        }
        else {
            //todo: go and find an alert model type and send here instead
            find<AlertView>(mapOf(AlertView::alert to "Failed login attempt", AlertView::message to "User not found")).openWindow(owner = null)
        }

        return user.id != null
    }
}