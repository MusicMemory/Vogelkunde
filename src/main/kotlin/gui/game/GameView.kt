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
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.stage.Stage


object GameView {

    lateinit var stage: Stage
    val scene: Scene
    val headerLabel = Label("Ornithology")
    val headerView = ImageView(Image("/images/title.png"))
    val footerLabel = Label()
    val answerBtns = Array<Button>(Config.noAnswers) { i -> Button("Antwort ${i+1}") }
    val imageView = ImageView()
    val borderPane = BorderPane()
    val gridPane = GridPane()

    init {
        scene = Scene(borderPane, Config.windowSize.first, Config.windowSize.second)
        scene.getStylesheets().add("/common.css")
        scene.getStylesheets().add("/game.css")

        borderPane.styleClass.add("border-pane")
        gridPane.styleClass.add("grid-pane")
        answerBtns.forEach { it.styleClass.add("answer-button") }
        headerLabel.styleClass.add("header-label");
        footerLabel.styleClass.add("footer-label")
        imageView.styleClass.add("image-view")

        imageView.fitWidth = 410.0
        imageView.isPreserveRatio = true

        borderPane.top = headerView // headerLabel;
        borderPane.bottom = footerLabel

        gridPane.add(imageView, 0, 0, 2, 1)
        for (i in 0..answerBtns.size-1) {
            gridPane.add(answerBtns[i], i%2, 1+i/2);
        }
        gridPane.setHgap(10.0)
        gridPane.setVgap(10.0)

        borderPane.center = gridPane
        BorderPane.setAlignment(headerView, Pos.TOP_CENTER)
        BorderPane.setAlignment(footerLabel, Pos.TOP_CENTER)
    }

    fun show() {
        stage.title = "Ornithology - Beantworte die 1. Frage..."
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