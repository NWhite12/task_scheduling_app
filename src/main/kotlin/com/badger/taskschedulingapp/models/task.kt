package com.badger.taskschedulingapp.models

import java.util.*
import javax.print.DocFlavor

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
class task (_id: Int, _user_key: Int, _title: String, _description: String, _due_date: Date, _priority_key: Int) {


    /*
        id      | holds the id of this task
        type    | int
    */
    var id: Int = _id
        get() {
            return field
        }
        set(value){
            field = value
        }

    /*
        user_key| holds the id of the user that created this task=
        type    | int
    */
    var user_key: Int = _user_key
        get() {
            return field
        }
        set(value) {
            field = value
        }

    /*
        title   | holds the title of the task
        type    | String
    */
    var title: String = _title
        get() {
            return field
        }
        set(value) {
            field = value
        }

    /*
        description | holds the description of the task
        type        | String
    */
    var description: String = _description
        get() {
            return field
        }
        set(value) {
            field = value
        }

    /*
        due_date| holds the due date of the task
        type    | Date
    */
    var due_date: Date = _due_date
        get() {
            return field
        }
        set(value) {
            field = value
        }

    /*
        priority_key    | holds the id of the priority level this task is
        type            | Int
    */
    var priority_key: Int = _priority_key
        get() {
            return field
        }
        set(value) {
            field = value
        }


}
