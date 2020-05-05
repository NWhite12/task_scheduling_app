package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.demo.app.User
import com.badger.taskschedulingapp.Main.models.DataSource
import com.badger.taskschedulingapp.Main.models.Priority
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.services.CrudService

abstract class AbstractPostgresqlSerivce<T, ID>: CrudService<T, ID> {

    val models = arrayOf((User::class.java),  (Task::class.java),  (Priority::class.java))
    protected val sessionFactory = DataSource.startSessionFactory("/postgresqlDB.properties", models)

    fun close(){
        //sessionFactory.currentSession.clear()
        sessionFactory.currentSession.close()
        sessionFactory.close()
    }
}