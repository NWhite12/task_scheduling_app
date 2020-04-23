package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.AlertController
import com.badger.taskschedulingapp.Main.staic.Styles
import tornadofx.*

class AlertView: View("Alert View") {

    val Controller: AlertController by inject()

    val alert: String by param()
    val message: String by param()


    override val root = borderpane{

        top = label(alert) {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = label(message) {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //right =

        bottom =  button ("OK" ){
            action{
                close()
            }

            tooltip("You did read the alert right?")

        }



    }

}