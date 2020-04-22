package com.badger.demo.app

import com.badger.taskschedulingapp.Main.models.Task
import java.io.Serializable
import javax.persistence.*

/*
    This class represent our 'users' table in the database_v1
    setters and getters are coded so easy to change default if needed.

    Holds the following fields:
    id
    name
    password

 */
@Entity
@Table(name="users")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        @Column(unique = true)
        var name: String? = null,
        var password: String? = null,
        @OneToMany(cascade=[CascadeType.ALL], mappedBy = "user")
        val tasks: List<Task> = emptyList()): Serializable {




}