package com.badger.taskschedulingapp.Main.controllers

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.views.AlertView
import tornadofx.*

class CreateTaskController(u: User): Controller() {
    val user = u


    fun save(title: String, description: String, due: String, priority: String): Boolean{
    var task: Task
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


        return saving
    }
}