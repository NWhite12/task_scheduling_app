package com.badger.taskschedulingapp.services

import com.badger.taskschedulingapp.models.Task

interface TaskService: CrudService<Task, Long> {
}