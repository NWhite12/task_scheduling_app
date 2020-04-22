package com.badger.taskschedulingapp.models

import java.io.Serializable
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
                     @Column(unique=true)
                     var title: String? = null,
                     @OneToMany(cascade=[CascadeType.ALL], mappedBy = "priority")
                     val tasks: List<Task> = emptyList()): Serializable {

}