package com.badger.taskschedulingapp.Test

import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService

fun main(args: Array<String>){
    var userService = UserPostgresService()
    val list = userService.findAll()
    for(user in list){
        userService.delete(user)
    }

    println(userService.findAll())


}