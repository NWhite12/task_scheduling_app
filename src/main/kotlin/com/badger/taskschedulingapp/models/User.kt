package com.badger.demo.app
/*
    This class represent our 'users' table in the database_v1
    setters and getters are coded so easy to change default if needed.

    Holds the following fields:
    id
    name
    password

 */
class User (_id: Int, _name: String, _password: String){


    /*
        id      | holds the id of this user
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
       name    | Name of this user
       type    | String
   */
    var name : String = _name
        get() {
            return field
        }
        set(value){
            field = value
        }

    /*
       password | holds the password for this user
       type     | string
       ***note*** password is currently unencrypted
   */
    var password : String = _password
        get() {
            return field
        }
        set(value){
            field = value
        }

}