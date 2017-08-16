package gui.start

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
    val answer1Btn = Button("Antwort 1")
    val answer2Btn = Button("Antwort 2")
    val answer3Btn = Button("Antwort 3")
    val answer4Btn = Button("Antwort 4")

    var imageView = ImageView()

    init {
        val pane = FlowPane()
        pane.children.add(imageView)
        pane.children.add(GameView.answer1Btn)
        pane.children.add(GameView.answer2Btn)
        pane.children.add(GameView.answer3Btn)
        pane.children.add(GameView.answer4Btn)
        scene = Scene(pane, 400.0, 400.0)
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