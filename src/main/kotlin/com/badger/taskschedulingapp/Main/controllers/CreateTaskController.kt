package com.badger.taskschedulingapp.Main.controllers

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService
import com.badger.taskschedulingapp.Main.services.postgresql.TaskPostgresService

import com.badger.taskschedulingapp.Main.views.AlertView
import com.badger.taskschedulingapp.Main.views.TaskListView
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

    fun save(title: String, description: String, due: String, priorityStr: String): Boolean{

        val server: TaskPostgresService = TaskPostgresService()
        val server2: PriorityPostgresService = PriorityPostgresService()
        val formatter = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH)

        var saving = false


        var priority = Priority()
        for(p in server2.findAll()) if(priorityStr == p.title) priority = p

        var task: Task = Task()
        task.title = title
        task.description = description
        task.due_date = formatter.parse(due)
        task.priority = priority
        task.user = user

        if (task.title == "" || task.priority == null){
            find<AlertView>(mapOf(AlertView::alert to "Invalid Task", AlertView::message to "Add a title to your task")).openWindow(owner = null)
        }
        else{
            server.save(task)

            find<AlertView>(mapOf(AlertView::alert to "Task saved", AlertView::message to "")).openWindow(owner = null)
            saving = true
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