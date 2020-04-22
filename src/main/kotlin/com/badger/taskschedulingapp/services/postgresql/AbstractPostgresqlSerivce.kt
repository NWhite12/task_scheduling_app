package com.badger.taskschedulingapp.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.models.DataSource
import com.badger.taskschedulingapp.models.DataSource.Companion.propertiesFromResource
import com.badger.taskschedulingapp.models.DataSource.Companion.toHibernateProperties
import com.badger.taskschedulingapp.models.Priority
import com.badger.taskschedulingapp.models.Task

abstract class AbstractPostgresqlSerivce<T, ID> {

    private val modelsList = arrayOf((User::class.java),  (Task::class.java),  (Priority::class.java))
    private val properties = propertiesFromResource("/postgresqlDB.properties")
    private val configuration = DataSource.buildHibernateConfiguration(properties.toHibernateProperties(), *modelsList)
    protected val sessionFactory = DataSource.buildSessionFactory(configuration)

    init {
        DataSource.addHibernateShutdownHook(sessionFactory)
    }

    abstract fun findAll(): Set<T>

    abstract fun findById(id:ID): T

    abstract fun save(obj:T): T

    abstract fun delete(obj:T)

    abstract fun deleteById(id:ID)

}