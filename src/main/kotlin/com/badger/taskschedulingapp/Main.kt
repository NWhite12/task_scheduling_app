package com.badger.taskschedulingapp

import com.badger.demo.app.User
import com.badger.taskschedulingapp.models.DataSource.Companion.addHibernateShutdownHook
import com.badger.taskschedulingapp.models.DataSource.Companion.buildHibernateConfiguration
import com.badger.taskschedulingapp.models.DataSource.Companion.buildSessionFactory
import com.badger.taskschedulingapp.models.DataSource.Companion.propertiesFromResource
import com.badger.taskschedulingapp.models.DataSource.Companion.toHibernateProperties
import com.badger.taskschedulingapp.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.models.Priority
import com.badger.taskschedulingapp.models.Task

fun main(args: Array<String>){
    var user = User()
    user.name = "nick"
    user.password = "1234"

    val properties = propertiesFromResource("/postgresqlDB.properties")

    val configuration = buildHibernateConfiguration(properties.toHibernateProperties(), (User::class.java), (Task::class.java), (Priority::class.java))
    val sessionFactory = buildSessionFactory(configuration)
    addHibernateShutdownHook(sessionFactory)

    sessionFactory.transaction { session ->
        session.save(user)
    }

    val entity = sessionFactory.transaction { session ->
        session.createQuery("from User").uniqueResult() as User
    }

    println(entity)

}