package gui.start

import domain.Config
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

object ResultView {

    lateinit var stage: Stage
    val scene: Scene
    val headerLabel = Label("Ornithology")
    val footerLabel = Label("2017, entwickelt für die Schutzstation Wattenmeer Hogge")
    val pointsLabel = Label()
    val onceAgainBtn = Button("Noch einmal spielen (j)")
    val terminateBtn = Button("Beenden (b)")
    val vBox = VBox()
    val borderPane = BorderPane()

    init {
        scene = Scene(borderPane, Config.windowSize.first, Config.windowSize.second)
        scene.getStylesheets().add("/common.css")
        scene.getStylesheets().add("/result.css")

        borderPane.styleClass.add("border-pane")
        vBox.styleClass.add("vbox")
        headerLabel.styleClass.add("header-label")
        footerLabel.styleClass.add("footer-label")
        pointsLabel.styleClass.add("points-label")

        onceAgainBtn.styleClass.add("term-button")
        terminateBtn.styleClass.add("term-button")

        vBox.children.add(pointsLabel)
        vBox.children.add(onceAgainBtn)
        vBox.children.add(terminateBtn)

        borderPane.top = headerLabel;
        borderPane.bottom = footerLabel
        borderPane.center = vBox
        BorderPane.setAlignment(headerLabel, Pos.TOP_CENTER)
    }

    fun show() {
        stage.title = "Ornithology - Ergebnis"
        stage.scene = scene
        stage.show()
    }

}