package gui.start

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object StartView {

    var scene: Scene
    val weiterButton = Button("Jetzt raten...")

    init {
        val pane = StackPane()
        pane.children.add(weiterButton)
        scene = Scene(pane, 400.0, 400.0)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - der Quiz"
        stage.scene = scene
        stage.show()
    }

}