package com.badger.taskschedulingapp.controllers

import com.badger.taskschedulingapp.view.WelcomeView
import javafx.application.Platform
import tornadofx.*
import kotlin.system.exitProcess

class WelcomeController: Controller() {

    fun startLogIn(){
        println("Open the log in page (from welcome view)") //TODO: make this open the login view page
        //find<WelcomeView>().openWindow(owner = null) TODO: replace welcome view with view of login page
    }

    fun closeApp(){
        println("Close the app! (from welcome view)") //TODO: take out when testing done
        Platform.exit()
        exitProcess(0)
    }


}