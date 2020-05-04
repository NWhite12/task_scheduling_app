package com.badger.taskschedulingapp.Main.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="alerts")
class Alert(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var title: String? = null,
        var message: String? = null): Serializable{

}