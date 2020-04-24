package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.TaskListController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.scene.control.SelectionMode
import tornadofx.*

class TaskListView: View("Task List View"){

    val Controller: TaskListController by inject()
    // todo: make this a user object from database
    val userName: String by param()

    override val root = borderpane() {

        //todo: use objects user name here
        top = label("${userName}'s Task list") {
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

            val taskobject: String = "test task"
            onDoubleClick {
                Controller.EditTask(taskobject)
                println("double click")
            }
        }

        //right =

        bottom = hbox {
            //todo: have this create a task pop up window
            button("Create Task") {
                action {
                    Controller.CreateTask()

                }
            }

            button("LogOut") {
                action {
                    Controller.Logout()
                    close()
                }

            }

        }

    }



}
