package com.badger.taskschedulingapp.Main.services

import com.badger.demo.app.User

interface UserService: CrudService<User, Long> {

    fun findByUserName(name: String): User
}