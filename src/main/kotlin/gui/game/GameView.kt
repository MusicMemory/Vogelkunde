package gui.start

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object GameView {

    var scene: Scene
    val weiterButton = Button("Zum Ende")

    init {
        val pane = StackPane()
        pane.children.add(GameView.weiterButton)
        scene = Scene(pane, 400.0, 400.0)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - Beantworte die Frage..."
        stage.scene = scene
        stage.show()
    }

}