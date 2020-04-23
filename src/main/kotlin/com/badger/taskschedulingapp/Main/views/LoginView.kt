package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.LoginController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.scene.control.TextField
import tornadofx.*

class LoginView: View("Login page") {
    val controller: LoginController by inject()

    var userName: TextField by singleAssign()
    var password: TextField by singleAssign()


    override val root = borderpane{

        top = label("Please login") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = vbox {

            label("User Name")
            userName = textfield (""){

            }

            label("Password")
            password = passwordfield (""){

            }

        }

        //right =

        bottom = hbox {

            button("Login") {
                action {
                    controller.loginAttempt(userName, password)
                }
            }

            button("Cancel") {
                action {
                    controller.cancelLogin()
                    cleanUp()
                }

            }


        }


        // TODO: use a form instead, would be cleaner in long run
        /*
        override val root = form {
            fieldset("Login", labelPosition = Orientation.VERTICAL) {
                field("User name"){
                    textfield().required()
                }
                field("Password"){
                    passwordfield().required()
                }
                buttonbar{
                    button("login"){
                        isDefaultButton = true
                        action {

                        }
                    }
                    button("Cancel"){
                        controller.cancelLogin()
                        cancelLogin()
                    }
                }
        }
        */


    }


    fun cleanUp(){
        userName.clear()
        password.clear()
        close()
    }


}