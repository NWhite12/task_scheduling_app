package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.controllers.EditTaskController
import com.badger.taskschedulingapp.Main.models.Task
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import tornadofx.*
import java.time.LocalDate

class EditTaskView: Fragment("Edit View") {

    val controller: EditTaskController by inject()

    var ttile: TextField by singleAssign()
    var tdescription: TextArea by singleAssign()
    var tdue: DatePicker by singleAssign()
    var tpriority: ComboBox<String> by singleAssign()

    val task: Task by param()
    val taskList: ObservableList<Task> by param()

    override val root = form {

        fieldset("${task.title}'s Edit Menu") {

            field("Title") {
                ttile = textfield(task.title)
            }

            field("Description") {
                tdescription = textarea {
                    prefRowCount = 5
                    text = task.description
                }
            }

            field("Due Date") {
                tdue = datepicker{
                    value = LocalDate.parse( (task.due_date.toString().split(' ')[0])) //todo: change to getting old values from database on this task
                }

            }

            label("Priority Level")
            tpriority = combobox<String> {
                items = controller.getPriority()
                value = task.priority?.title.toString()
            }

        }


    button("Delete"){
        action {
            if (controller.delete(task))
                close()
        }
    }

    button("Save"){
        action {
            taskList.add(controller.save(ttile.text, tdescription.text, tdue.value.toString(), tpriority.value.toString(),task))
            taskList.remove(task)
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