package com.badger.taskschedulingapp.Main.controllers

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
    }
}