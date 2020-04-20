package com.badger.taskschedulingapp.models

import javax.persistence.*

/*
    This class represent our 'priority' table in the database_v1
    setters and getters are coded so easy to change default if needed.

    Holds the following fields:
    id
    title
 */
@Entity
@Table(name="priorities")
data class Priority (@Id
                     @GeneratedValue(strategy = GenerationType.AUTO)
                     var id: Long? = null,
                     var title: String? = null,
                     @OneToMany(cascade=[CascadeType.ALL])
                     @JoinColumn(name="task_id")
                     val tasks: List<Task> = emptyList()) {

}