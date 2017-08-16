package gui.start

import domain.Config
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

object GameView {

    var scene: Scene
    val answerBtns = Array<Button>(Config.noAnswers) { i -> Button("Antwort ${i+1}") }
    var imageView = ImageView()

    init {
        val pane = FlowPane()
        pane.children.add(imageView)
        answerBtns.forEach { pane.children.add(it) }
        scene = Scene(pane, Config.windowSize.first, Config.windowSize.second)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - Beantworte die Frage..."
        stage.scene = scene
        stage.show()
    }

    fun setImage(image: Image) {
        imageView.image = image;
    }

}