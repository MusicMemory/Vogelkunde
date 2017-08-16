package gui.start

import domain.Config
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object ResultView {

    var scene: Scene
    val pointsLbl = Label()
    val onceAgainBtn = Button("Noch einmal spielen")
    val terminateBtn = Button("Beenden")

    init {
        val pane = FlowPane()
        pane.children.add(pointsLbl)
        pane.children.add(onceAgainBtn)
        pane.children.add(terminateBtn)
        scene = Scene(pane, Config.windowSize.first, Config.windowSize.second)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - Ergebnis"
        stage.scene = scene
        stage.show()
    }

}