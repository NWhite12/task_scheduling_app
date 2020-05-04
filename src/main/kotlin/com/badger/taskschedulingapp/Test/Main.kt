package com.badger.taskschedulingapp.Test

import com.badger.taskschedulingapp.Main.services.postgresql.PriorityPostgresService
import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService
import javafx.collections.FXCollections


fun main(args: Array<String>){
    val server = PriorityPostgresService()

    val list = server.findAll()

    val example = FXCollections.observableArrayList<String>()

    for (priority in list){
        example.add(priority.title.toString())
    }


    print(example)
}