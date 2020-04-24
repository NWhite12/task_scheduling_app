package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.DataSource
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.models.Task

abstract class AbstractPostgresqlSerivce<T, ID> {

    val models = arrayOf((User::class.java),  (Task::class.java),  (Priority::class.java))
    protected val sessionFactory = DataSource.startSessionFactory("/postgresqlDB.properties", models)

    abstract fun findAll(): List<T>

    abstract fun findById(id:ID): T

    abstract fun save(obj:T): T

    abstract fun delete(obj:T)

    abstract fun deleteById(id:ID)

    abstract fun update(obj: T)


}