package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.EditTaskController
import com.badger.taskschedulingapp.Main.models.Task
import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*
import java.time.LocalDate

class EditTaskView: View("Edit View") {

    val controller: EditTaskController by inject()

    var ttile: TextField by singleAssign()
    var tdescription: TextArea by singleAssign()
    var tdue: DatePicker by singleAssign()
    var tpriority: ComboBox<String> by singleAssign()

    //todo: change to a task object
    val task: Task by param()

    override val root = form {

        fieldset("${task.title}'s Edit Menu") {

            field("Title") {
                ttile = textfield("${task.title} title") //todo: change to getting old values from database on this task
            }

            field("Description") {
                tdescription = textarea {
                    prefRowCount = 5
                    text = "${task.description} description!!!" //todo: change to getting old values from database on this task
                }
            }

            field("Due Date") {
                tdue = datepicker{
                    value = LocalDate.parse("2000-01-01") //todo: change to getting old values from database on this task
                }

            }

            //todo: make this a pull from database instead
            val example = FXCollections.observableArrayList("high", "Mid", "low")
            label("Priority Level")
            tpriority = combobox<String> {
                items = example
                value = "high" //todo: change to getting old values from database on this task
            }

        }


    button("Delete"){
        action {
            if (controller.delete(ttile.text))
                close()
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