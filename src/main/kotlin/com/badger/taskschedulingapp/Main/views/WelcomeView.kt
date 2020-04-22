package com.badger.taskschedulingapp.Main.view

import com.badger.taskschedulingapp.Main.controllers.WelcomeController
import com.badger.taskschedulingapp.Main.staic.Styles
import tornadofx.*


class WelcomeView : View("Hello TornadoFX") {
    val controller: WelcomeController by inject()

    override val root = borderpane{

        top = label("Welcome to the todo list app!") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        bottom = vbox {

            button("login") {
                action {
                    controller.startLogIn()
                }
            }

            button ("exit" ){
                action{
                    controller.closeApp()
                }

                tooltip("Closes the application")

            }


        }

        //left =

        //right =

        center = label("") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

    }


}