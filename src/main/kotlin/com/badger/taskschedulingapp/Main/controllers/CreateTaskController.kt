package com.badger.taskschedulingapp.Main.controllers

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService
import com.badger.taskschedulingapp.Main.services.postgresql.TaskPostgresService
import com.badger.taskschedulingapp.Main.views.AlertView
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*
import java.text.SimpleDateFormat
import java.util.*

class CreateTaskController(u: User): Controller() {
    val user = u
    val priorityList = PriorityPostgresService().findAll()

    fun save(title: String, description: String, due: String, priority: String): Task{

        var task: Task = Task()
        var foundP = Priority()

        val formatter = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH)

        for (pri in priorityList){

            if (priority == pri.title){
                foundP = pri
            }
        }
        task.title = title
        task.description = description
        task.due_date = formatter.parse(due)
        task.priority = foundP
        task.user = user

        val taskService = TaskPostgresService()
        taskService.save(task)
        taskService.close()

        //todo: replace this with a save call to modles for datbase
        println("title is $title")
        println("Descripton is $description")
        println("Due date is $due")
        println("Priority is $priority")

        //todo: do a real saving call to the database
        val saving: Boolean = true

        if (saving){
            find<AlertView>(mapOf(AlertView::alert to "$title added", AlertView::message to "your task has been added to the system")).openWindow(owner = null)
        }
        else{
            find<AlertView>(mapOf(AlertView::alert to "Faild saving the task", AlertView::message to "please check your values or contact system admin")).openWindow(owner = null)
        }


        return task
    }

    fun getPriority(): ObservableList<String>? {

        val server = PriorityPostgresService()

        val list = server.findAll()

        val example = FXCollections.observableArrayList<String>()

        for (priority in list){
            example.add(priority.title.toString())
        }

        return example
    }
}