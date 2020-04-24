package com.badger.taskschedulingapp.Test

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.services.postgresql.UserPostgresService

fun main(args: Array<String>){
    var user = User()
    var userService = UserPostgresService()
    user = userService.findByUserName("Nick")
    //user.name = "Nick"
    user.password = "5678"


    userService.save(user)
    println(userService.findByUserName("Nick"))


}