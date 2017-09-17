package gui.start

import Main
import domain.Config
import javafx.concurrent.Task
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color


object GameView {

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
        scene.getStylesheets() += "/common.css"
        scene.getStylesheets() += "/game.css"

        borderPane.styleClass += "border-pane"
        gridPane.styleClass += "grid-pane"
        answerBtns.forEach { it.styleClass += "answer-button" }
        headerLabel.styleClass += "header-label"
        footerLabel.styleClass += "footer-label"
        imageView.styleClass += "image-view"

        imageView.fitWidth =  Config.windowSize.first * 0.8 + 10
        answerBtns.forEach { it.prefWidth = Config.windowSize.first * 0.4 }
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
        Main.stage.title = "Ornithology - Beantworte die 1. Frage..."
        Main.stage.scene = scene
        Main.stage.show()
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