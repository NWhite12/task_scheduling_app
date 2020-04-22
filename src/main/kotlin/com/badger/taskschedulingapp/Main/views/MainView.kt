package com.badger.taskschedulingapp.Main.views

import com.badger.taskschedulingapp.Main.staic.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}