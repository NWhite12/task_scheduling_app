package com.badger.taskschedulingapp.services.postgresql

import com.badger.taskschedulingapp.models.Task
import com.badger.taskschedulingapp.services.TaskService

class TaskPostgresService: AbstractPostgresqlSerivce<Task, Long>(), TaskService {

    override fun findAll(): Set<Task>{
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Task {
        TODO("Not yet implemented")
    }

    override fun save(obj: Task): Task {
        TODO("Not yet implemented")
    }

    override fun delete(obj: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}