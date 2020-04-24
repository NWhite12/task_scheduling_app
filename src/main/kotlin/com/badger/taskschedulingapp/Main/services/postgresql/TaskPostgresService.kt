package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.taskschedulingapp.Main.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.Main.models.Task
import com.badger.taskschedulingapp.Main.services.TaskService

class TaskPostgresService: AbstractPostgresqlSerivce<Task, Long>(), TaskService {

    override fun findAll(): List<Task> {
        return sessionFactory.transaction { session -> session.createQuery("from Task").resultList } as List<Task>
    }


    override fun findById(id: Long): Task {
        return sessionFactory.transaction { session ->
            session.get(Task::class.java, id)} as Task
    }

    override fun save(obj: Task): Task {
        return findById(sessionFactory.transaction { session ->
            session.save(obj)
        } as Long)
    }

    override fun delete(obj: Task) {
        sessionFactory.transaction {session -> session.delete(obj)}
    }

    override fun deleteById(id: Long) {
        delete(sessionFactory.transaction {session ->session.load(Task::class.java, id)
        }as Task)
    }

    override fun update(obj: Task) {
        sessionFactory.transaction {session -> session.update(obj)}
    }
}