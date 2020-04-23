package com.badger.taskschedulingapp.view

import com.badger.taskschedulingapp.controllers.WelcomeController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.application.Platform
import tornadofx.*
import kotlin.system.exitProcess


class WelcomeView : View("Hello TornadoFX") {
    val controller: WelcomeController by inject()

    override val root = borderpane{

        top = label("Welcome to the todo list app!") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = label("") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //right =

        bottom = vbox {

            button("login") {
                action {
                    controller.startLogIn()
                    openLogin()
                }
            }

            button ("exit" ){
                action{
                    controller.closeApp()
                    killProgram()
                }

                tooltip("Closes the application")

            }

        }


    }



    fun openLogin(){
        find<LoginView>().openWindow(owner = null)
        close()
    }


    fun killProgram(){
        Platform.exit()
        exitProcess(0)
    }

}