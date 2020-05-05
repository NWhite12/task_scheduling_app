package com.badger.taskschedulingapp.Test

import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService


fun main(args: Array<String>){

    val ser3 = PriorityPostgresService()
    val priority = Priority()
    priority.id = 32



    ser3.deleteById(85)

}