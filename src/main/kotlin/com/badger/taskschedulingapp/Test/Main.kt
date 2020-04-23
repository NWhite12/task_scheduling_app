package com.badger.taskschedulingapp.Test

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService

fun main(args: Array<String>){
    var user = User()
    user.name ="Tom"
    user.password = "1234"

    val userService = UserPostgresService()

    userService.deleteById(13)
    println(userService.findAll())


}