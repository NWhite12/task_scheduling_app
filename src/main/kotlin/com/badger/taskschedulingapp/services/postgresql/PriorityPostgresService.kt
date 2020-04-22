package com.badger.taskschedulingapp.services.postgresql

import com.badger.taskschedulingapp.models.Priority
import com.badger.taskschedulingapp.services.PriorityService

class PriorityPostgresService: AbstractPostgresqlSerivce<Priority, Long>(), PriorityService{

    override fun findAll(): Set<Priority> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Priority {
        TODO("Not yet implemented")
    }

    override fun save(obj: Priority): Priority {
        TODO("Not yet implemented")
    }

    override fun delete(obj: Priority) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}