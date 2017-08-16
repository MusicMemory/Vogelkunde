package gui.start

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.FlowPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object ResultView {

    var scene: Scene
    val onceAgainBtn = Button("Noch einmal spielen")
    val terminateBtn = Button("Beenden")

    init {
        val pane = FlowPane()
        pane.children.add(onceAgainBtn)
        pane.children.add(terminateBtn)
        scene = Scene(pane, 400.0, 400.0)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - Ergebnis"
        stage.scene = scene
        stage.show()
    }

}