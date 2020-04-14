package com.badger.taskschedulingapp.view

import com.badger.taskschedulingapp.staic.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}