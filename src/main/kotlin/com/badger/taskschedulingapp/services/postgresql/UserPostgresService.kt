package com.badger.taskschedulingapp.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.services.UserService

class UserPostgresService: AbstractPostgresqlSerivce<User, Long>(), UserService {
    override fun findAll(): Set<User> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun save(obj: User): User {

        return findById(sessionFactory.transaction { session ->
           session.save(obj)
        } as Long)
    }

    override fun delete(obj: User) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}