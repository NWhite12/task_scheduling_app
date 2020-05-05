package com.badger.taskschedulingapp.Test

import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService
import com.badger.taskschedulingapp.Main.services.postgresql.TaskPostgresService
import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService
import javafx.collections.FXCollections
import org.h2.engine.User
import java.time.LocalDate
import java.util.*


fun main(args: Array<String>){

    val ser = TaskPostgresService()
    val ser2 = UserPostgresService()
    val ser3 = PriorityPostgresService()


    val user  = ser2.findByUserName("Peter")

    val date = Date()


    val pir = ser3.findById(33)
    val task = Task(title = "testing", description = "testing again", due_date = date, user = user, priority = pir)

    ser.save(task)
}