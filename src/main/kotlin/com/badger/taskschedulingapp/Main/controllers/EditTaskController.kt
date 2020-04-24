package com.badger.taskschedulingapp.Main.controllers

import com.badger.taskschedulingapp.Main.views.AlertView
import tornadofx.*

class EditTaskController: Controller() {

    fun save(title: String, description: String, due: String, priority: String): Boolean{

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

    fun delete(taskobject: String): Boolean{
        println("delteing $taskobject")
        //todo: do a real delete call to the database
        val test: Boolean = true

        if(test){
            println("deleted the task")
            find<AlertView>(mapOf(AlertView::alert to " deleted the task", AlertView::message to "your task was deleted")).openWindow(owner = null)
        }
        else{
            find<AlertView>(mapOf(AlertView::alert to "Faild delteing the task", AlertView::message to "please check your values or contact system admin")).openWindow(owner = null)
        }

        return test
    }

}