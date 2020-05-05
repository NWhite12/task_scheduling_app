package com.badger.taskschedulingapp.Main.views

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.controllers.TaskListController
import com.badger.taskschedulingapp.Main.staic.Styles
import javafx.collections.FXCollections
import javafx.scene.control.SelectionMode
import tornadofx.*

class TaskListView: Fragment("Task List View"){

    val user: User by param()
    val controller = TaskListController(user)
    val taskList = FXCollections.observableList(user.tasks)

    override val root = borderpane() {

        top = label("${user.name}'s Task list") {
            useMaxWidth = true
            addClass(Styles.heading)

        }

        //left =

        center = listview(taskList) {
            selectionModel.selectionMode = SelectionMode.SINGLE

            /*
            selectionModel.selectedItemProperty().addListener(ChangeListener<Task>(){
                @Override fun changed(observable: ObservableValue<Any?: Task>)
            })
            */

            onDoubleClick {
                controller.EditTask(selectionModel.selectedItem, taskList)
                println("double click")
            }
        }

        //right =

        bottom = hbox {
            //todo: have this create a task pop up window
            button("Create Task") {
                action {
                    controller.CreateTask(taskList)

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
