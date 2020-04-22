package com.badger.taskschedulingapp.services.postgresql


import com.badger.taskschedulingapp.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.models.Priority
import com.badger.taskschedulingapp.services.PriorityService

class PriorityPostgresService: AbstractPostgresqlSerivce<Priority, Long>(), PriorityService{

    override fun findAll(): Set<Priority> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Priority {
        return sessionFactory.transaction { session ->
            session.get(Priority::class.java, id)
        }
    }


    override fun save(obj: Priority): Priority {
        return findById(sessionFactory.transaction { session ->
            session.save(obj)
        } as Long)
    }

    override fun delete(obj: Priority) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}