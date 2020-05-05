package com.badger.taskschedulingapp.Main.controllers

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


class EditTaskController: Controller() {
    val priorityList = PriorityPostgresService().findAll()

    fun save(title: String, description: String, due: String, priority: String, task: Task): Task{

        //todo: replace this with a save call to modles for datbase
        println("title is $title")
        println("Descripton is $description")
        println("Due date is $due")
        println("Priority is $priority")

        val server = TaskPostgresService()
        var foundP = Priority()

        for (pri in priorityList){

            if (priority == pri.title){
                foundP = pri
            }
        }

        val formatter = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH)
        val id = task.id as Long
        val user = task.user

        val updateTask: Task = Task()
        updateTask.title = title
        updateTask.description = description
        updateTask.due_date = formatter.parse(due)
        updateTask.priority = foundP
        updateTask.user = user

        //val task = Task(title = title, description = description, due_date = formatter.parse(due), priority = foundP)
        server.deleteById(id)
        server.save(updateTask)

        //todo: do a real saving call to the database
        val saving: Boolean = true

        if (saving){
            find<AlertView>(mapOf(AlertView::alert to "$title added", AlertView::message to "your task has been added to the system")).openWindow(owner = null)
        }
        else{
            find<AlertView>(mapOf(AlertView::alert to "Faild saving the task", AlertView::message to "please check your values or contact system admin")).openWindow(owner = null)
        }
        return updateTask

    }

    fun delete(task: Task): Boolean{
        println("delteing $task")
        //todo: do a real delete call to the database
        val test: Boolean = true

        val server = TaskPostgresService()

        server.delete(task)

        if(test){
            println("deleted the task")
            find<AlertView>(mapOf(AlertView::alert to " deleted the task", AlertView::message to "your task was deleted")).openWindow(owner = null)
        }
        else{
            find<AlertView>(mapOf(AlertView::alert to "Faild delteing the task", AlertView::message to "please check your values or contact system admin")).openWindow(owner = null)
        }

        return test
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