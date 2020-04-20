package com.badger.taskschedulingapp.staic

import javafx.geometry.Pos
import javafx.scene.paint.Paint
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.Color
import java.awt.Color.black

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()

    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        button{
            fontSize = 20.px
            alignment = Pos.CENTER
        }
    }
}