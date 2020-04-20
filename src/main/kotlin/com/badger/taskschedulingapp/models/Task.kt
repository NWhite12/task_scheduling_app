package com.badger.taskschedulingapp.models

import com.badger.demo.app.User
import java.util.*
import javax.persistence.*

/*
    This class represent our 'task' table in the database_v1
    setters and getters are coded so easy to change default if needed.

    Holds the following fields:
    id
    user_key
    description
    due_date
    priority_key
 */
@Entity
@Table(name="tasks")
data class Task (@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 var id: Long? = null,
                 var title: String? = null,
                 var description: String? = null,
                 var due_date: Date? = null,
                 @ManyToOne
                 var user: User? = null,
                 @ManyToOne
                 var priority: Priority) {

}
