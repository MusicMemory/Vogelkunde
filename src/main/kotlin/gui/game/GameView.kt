package gui.start

import domain.Config
import javafx.concurrent.Task
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.stage.Stage


object GameView {

    lateinit var stage: Stage
    val scene: Scene
    val headerLabel = Label("Ornithology")
    val footerLabel = Label()
    val answerBtns = Array<Button>(Config.noAnswers) { i -> Button("Antwort ${i+1}") }
    val imageView = ImageView()
    val borderPane = BorderPane()

    init {
        val pane = FlowPane()
        pane.children.add(imageView)
        pane.children.addAll(answerBtns)
        pane.children.add(footerLabel);
        answerBtns.forEach { it.styleClass.add("answer-button") }

        headerLabel.styleClass.add("header-label");
        footerLabel.styleClass.add("footer-label")
        imageView.fitWidth = 410.0
        imageView.isPreserveRatio = true
        imageView.styleClass.add("image-view")

        borderPane.styleClass.add("border-pane")
        borderPane.top = headerLabel;
        borderPane.bottom = footerLabel

        val gridPane = GridPane()
        gridPane.add(imageView, 0, 0, 2, 1)

        for (i in 0..answerBtns.size-1) {
            gridPane.add(answerBtns[i], i%2, 1+i/2);
        }
        gridPane.styleClass.add("grid-pane")
        gridPane.setHgap(10.0) //horizontal gap in pixels => that's what you are asking for
        gridPane.setVgap(10.0) //vertical gap in pixels
        gridPane.setPadding(Insets(10.0, 10.0, 10.0, 10.0))

        borderPane.center = gridPane
        BorderPane.setAlignment(headerLabel, Pos.TOP_CENTER)
        BorderPane.setAlignment(footerLabel, Pos.TOP_CENTER)

        scene = Scene(borderPane, Config.windowSize.first, Config.windowSize.second)
        scene.getStylesheets().add("/common.css")
        scene.getStylesheets().add("/game.css")
    }

    fun show() {
        stage.title = "Ornithology - Beantworte die Frage..."
        stage.scene = scene
        stage.show()
    }

    fun showCorrectness(correct: Boolean) {
        if (correct) {
            GameView.footerLabel.text = "Richtig"
            GameView.footerLabel.textFill = Color(0.0, 0.8, 0.0, 1.0)
        }
        else {
            GameView.footerLabel.text = "Falsch"
            GameView.footerLabel.textFill = Color.RED
        }
        val sleeper = object: Task<Void>() {
            override fun call(): Void? {
                Thread.sleep(500)
                return null
            }
        }
        sleeper.setOnSucceeded {
            GameView.footerLabel.text = ""
        }
        Thread(sleeper).start();
    }

    fun setImage(image: Image) {
        imageView.image = image;
    }

}