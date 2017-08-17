package gui.start

import domain.Config
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.FlowPane
import javafx.stage.Stage

object StartView {

    lateinit var stage: Stage
    val scene: Scene
    val difficulty1Btn = Button("Schwierigkeit 1")
    val difficulty2Btn = Button("Schwierigkeit 2")
    val difficulty3Btn = Button("Schwierigkeit 3")

    init {
        val pane = FlowPane()
        pane.children.add(difficulty1Btn)
        pane.children.add(difficulty2Btn)
        pane.children.add(difficulty3Btn)
        scene = Scene(pane, Config.windowSize.first, Config.windowSize.second)
    }

    fun show() {
        stage.title = "Ornithology - der Quiz"
        stage.scene = scene
        stage.show()
    }

}