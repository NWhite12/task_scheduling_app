package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.CreateTaskController
import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*


class CreateTaskView: View("Create Task View") {

    val controller: CreateTaskController by inject()

    var ttile: TextField by singleAssign()
    var tdescription: TextArea by singleAssign()
    var tdue: DatePicker by singleAssign()
    var tpriority: ComboBox<String> by singleAssign()

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
            val example = FXCollections.observableArrayList("high","Mid", "low")
            label("Priority Level")
            tpriority = combobox<String>{
                items = example
            }

        }


        button("Save"){
            action {
                if (controller.save(ttile.text, tdescription.text, tdue.value.toString(), tpriority.value.toString()))
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