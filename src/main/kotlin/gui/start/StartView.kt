package gui.start

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.FlowPane
import javafx.stage.Stage

object StartView {

    var scene: Scene
    val difficulty1Btn = Button("Schwierigkeit 1")
    val difficulty2Btn = Button("Schwierigkeit 2")
    val difficulty3Btn = Button("Schwierigkeit 3")

    init {
        val pane = FlowPane()
        pane.children.add(difficulty1Btn)
        pane.children.add(difficulty2Btn)
        pane.children.add(difficulty3Btn)
        scene = Scene(pane, 400.0, 400.0)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - der Quiz"
        stage.scene = scene
        stage.show()
    }

}