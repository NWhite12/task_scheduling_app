package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.Main.services.UserService

class UserPostgresService: AbstractPostgresqlSerivce<User, Long>(), UserService {
    override fun findAll(): List<User> {
       return sessionFactory.transaction { session -> session.createQuery("from User").resultList } as List<User>
    }

    override fun findById(id: Long): User {
        return sessionFactory.transaction { session ->
            session.get(User::class.java, id)} as User
    }

    override fun save(obj: User): User {
            return findById(sessionFactory.transaction { session ->
                session.save(obj)
            } as Long)

    }

    override fun delete(obj: User) {
        sessionFactory.transaction {session -> session.delete(obj)}
    }

    override fun deleteById(id: Long) {

        sessionFactory.transaction {session -> val obj = session.load(User::class.java, id) as User
            session.delete(obj)
        }
    }
}