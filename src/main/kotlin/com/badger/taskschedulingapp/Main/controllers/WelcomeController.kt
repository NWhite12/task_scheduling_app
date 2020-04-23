package com.badger.taskschedulingapp.Main.controllers

import com.badger.taskschedulingapp.Main.views.LoginView
import tornadofx.*


class WelcomeController: Controller() {

    fun startLogIn(){
        println("Open the log in page (from welcome view)")
        find<LoginView>().openWindow(owner = null)
    }

    fun closeApp(){
        println("Close the app! (from welcome view)")

    }


}