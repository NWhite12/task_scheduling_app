package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.taskschedulingapp.Main.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.services.TaskService

class TaskPostgresService: AbstractPostgresqlSerivce<Task, Long>(), TaskService {

    override fun findAll(): Set<Task>{
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Task {
        return sessionFactory.transaction { session ->
            session.get(Task::class.java, id)}
    }

    override fun save(obj: Task): Task {
        return findById(sessionFactory.transaction { session ->
            session.save(obj)
        } as Long)
    }

    override fun delete(obj: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}