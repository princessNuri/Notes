package com.example.notesapp.data.models

import java.io.Serializable

data class User(
     val name:String = " ",
     val email:String = " ",
     val password:Int=0,
):Serializable
