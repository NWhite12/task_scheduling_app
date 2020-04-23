package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.DataSource
import com.badger.taskschedulingapp.Main.models.DataSource.Companion.propertiesFromResource
import com.badger.taskschedulingapp.Main.models.DataSource.Companion.toHibernateProperties
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.models.Task

abstract class AbstractPostgresqlSerivce<T, ID> {

    private val modelsList = arrayOf((User::class.java),  (Task::class.java),  (Priority::class.java))
    private val properties = propertiesFromResource("/postgresqlDB.properties")
    private val configuration = DataSource.buildHibernateConfiguration(properties.toHibernateProperties(), *modelsList)
    protected val sessionFactory = DataSource.buildSessionFactory(configuration)

    init {
        DataSource.addHibernateShutdownHook(sessionFactory)
        sessionFactory.openSession()
    }

    abstract fun findAll(): List<T>

    abstract fun findById(id:ID): T

    abstract fun save(obj:T): T

    abstract fun delete(obj:T)

    abstract fun deleteById(id:ID)

}