package gui.start

import domain.Config
import javafx.concurrent.Task
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.FlowPane
import javafx.stage.Stage

object GameView {

    var scene: Scene
    val answerBtns = Array<Button>(Config.noAnswers) { i -> Button("Antwort ${i+1}") }
    var imageView = ImageView()
    val correctnessLbl = Label()

    init {
        val pane = FlowPane()
        pane.children.add(imageView)
        pane.children.addAll(answerBtns)
        pane.children.add(correctnessLbl);
        scene = Scene(pane, Config.windowSize.first, Config.windowSize.second)
    }

    fun show(stage: Stage) {
        stage.title = "Ornithology - Beantworte die Frage..."
        stage.scene = scene
        stage.show()
    }

    fun showCorrectness(correct: Boolean) {
        GameView.correctnessLbl.text = if (correct) "Richtig" else "Falsch"
        val sleeper = object: Task<Void>() {
            override fun call(): Void? {
                Thread.sleep(500)
                return null
            }
        }
        sleeper.setOnSucceeded {
            GameView.correctnessLbl.text = ""
        }
        Thread(sleeper).start();
    }

    fun setImage(image: Image) {
        imageView.image = image;
    }

}