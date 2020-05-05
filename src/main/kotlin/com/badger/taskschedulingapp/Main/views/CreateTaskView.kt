package com.badger.taskschedulingapp.Main.views

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.controllers.CreateTaskController
import com.badger.taskschedulingapp.Main.models.Task
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*


class CreateTaskView: Fragment("Create Task View") {

    val user: User by param()
    val controller = CreateTaskController(user)

    var ttile: TextField by singleAssign()
    var tdescription: TextArea by singleAssign()
    var tdue: DatePicker by singleAssign()
    var tpriority: ComboBox<String> by singleAssign()

    val taskList: ObservableList<Task> by param()

    override val root = form{

        fieldset("Create a Task"){

            field("Title"){
                ttile =  textfield()
            }

            field("Description"){
                tdescription = textarea {
                    prefRowCount = 5
                }
            }

            field("Due Date"){
              tdue =  datepicker()
            }

            //todo: make this a pull from database instead
            label("Priority Level")
            tpriority = combobox<String> {
                items = controller.getPriority()
            }

        }


        button("Save"){
            action {
                taskList.add(controller.save(ttile.text, tdescription.text, tdue.value.toString(), tpriority.value.toString()))
                close()
            }
        }

        button("Cancel"){
            action {
                close()
            }
        }

    }



}