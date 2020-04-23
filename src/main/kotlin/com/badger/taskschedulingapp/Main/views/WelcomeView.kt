package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.WelcomeController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.application.Platform
import tornadofx.*
import kotlin.system.exitProcess


class WelcomeView : View("Welcome") {
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
                    cleanUp()
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



    fun cleanUp(){
        close()
    }


    fun killProgram(){
        Platform.exit()
        exitProcess(0)
    }

}