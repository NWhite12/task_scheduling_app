package com.badger.taskschedulingapp.Main.services

interface CrudService<T, ID> {
    fun findAll(): List<T>

    fun findById(id:ID): T

    fun save(obj:T): T

    fun delete(obj:T)

    fun deleteById(id:ID)

    fun update(obj:T)

}