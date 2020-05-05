package com.badger.taskschedulingapp.Test

import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService


fun main(args: Array<String>){

    val ser3 = PriorityPostgresService()
    val priority = Priority()
    priority.id = 32
    priority.title = "Medium"

    ser3.deleteById(66)
    ser3.deleteById(71)
    ser3.deleteById(73)
    ser3.deleteById(75)

}