package com.badger.taskschedulingapp.Main.views

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.controllers.TaskListController
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.collections.ObservableList
import javafx.collections.transformation.SortedList
import javafx.scene.control.SelectionMode
import tornadofx.*

class TaskListView: View("Task List View"){

    val controller: TaskListController by inject()
    val user: User by param()
    val taskList = user.tasks


    override val root = borderpane() {

        top = label("${user.name}'s Task list") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = listview<Task> {
            selectionModel.selectionMode = SelectionMode.SINGLE

            for(task in user.tasks) items.add(task)

            onDoubleClick {
                controller.EditTask(selectionModel.selectedItem)
                println("double click")
            }
        }

        //right =

        bottom = hbox {
            //todo: have this create a task pop up window
            button("Create Task") {
                action {
                    controller.CreateTask()

                }
            }

            button("LogOut") {
                action {
                    controller.Logout()
                    close()
                }

            }

        }

    }



}
