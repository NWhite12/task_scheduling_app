package com.badger.taskschedulingapp.Main.views

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.controllers.TaskListController
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.SelectionMode
import tornadofx.*
import java.util.*

class TaskListView: Fragment("Task List View"){

    val user: User by param()
    val controller = TaskListController(user)

    override val root = borderpane() {

        top = label("${user.name}'s Task list") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = listview(controller.getTasks(user)) {
            selectionModel.selectionMode = SelectionMode.SINGLE

            /*
            selectionModel.selectedItemProperty().addListener(ChangeListener<Task>(){
                @Override fun changed(observable: ObservableValue<Any?: Task>)
            })
            */

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
                    controller.CreateTask(controller)

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
