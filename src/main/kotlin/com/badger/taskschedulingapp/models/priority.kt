package com.badger.taskschedulingapp.models

/*
    This class represent our 'priority' table in the database_v1
    setters and getters are coded so easy to change default if needed.

    Holds the following fields:
    id
    title
 */
class priority (_id: Int, _title: String){

    /*
        id      | holds the id of this priority
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
        title   | holds the title for the priority
        type    | String
    */
    var title: String = _title
        get() {
            return field
        }
        set(value){
            field = value
        }
}