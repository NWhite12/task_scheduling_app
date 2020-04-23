package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.TaskListController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.scene.control.SelectionMode
import tornadofx.*

class TaskListView: View("Task List View"){

    val Controller: TaskListController by inject()


    override val root = borderpane() {

        //todo: use the users name here
        top = label("'s Task list") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        //todo: have this dispaly tasks pulled form database
        center = listview<String> {
            items.add("task1")
            items.add("task2")
            items.add("task3")

            selectionModel.selectionMode = SelectionMode.SINGLE
        }

        //right =

        bottom = hbox {
            //todo: have this create a task pop up window
            button("Create Task") {
                action {

                }
            }

            button("LogOut") {
                action {
                    Controller.Logout()
                    cleanUp()
                }

            }

        }

    }



    fun cleanUp(){
        close()
    }
}
