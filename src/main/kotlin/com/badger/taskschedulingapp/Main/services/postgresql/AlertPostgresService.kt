package com.badger.taskschedulingapp.Main.services.postgresql

import com.badger.taskschedulingapp.Main.models.Alert
import com.badger.taskschedulingapp.Main.models.DataSource.Companion.transaction
import com.badger.taskschedulingapp.Main.services.AlertService

class AlertPostgresService:AbstractPostgresqlSerivce<Alert, Long>(), AlertService {
    override fun findAll(): List<Alert> {
        return sessionFactory.transaction { session -> session.createQuery("from Priority").resultList } as List<Alert>
    }

    override fun findById(id: Long): Alert {
        return sessionFactory.transaction { session ->
            session.get(Alert::class.java, id)
        } as Alert
    }


    override fun save(obj: Alert): Alert {
        return findById(sessionFactory.transaction { session ->
            session.save(obj)
        } as Long)
    }

    override fun delete(obj: Alert) {
        sessionFactory.transaction {session -> session.delete(obj)}
    }

    override fun deleteById(id: Long) {
        delete(sessionFactory.transaction {session ->session.load(Alert::class.java, id)
        }as Alert)
    }

    override fun update(obj: Alert) {
        sessionFactory.transaction {session -> session.update(obj)}
    }
}