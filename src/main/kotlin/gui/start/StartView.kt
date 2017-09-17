package gui.start

import Main
import domain.Config
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox

object StartView {

    val scene: Scene
    val headerLabel = Label("Ornithology")
    val headerView = ImageView(Image("/images/title.png"))
    val footerLabel = Label("2017, entwickelt für die Schutzstation Wattenmeer Hooge")
    val difficulty1Button = Button("Geringe Schwierigkeit (1)")
    val difficulty2Button = Button("Mittlere Schwierigkeit (2)")
    val difficulty3Button = Button("Hohe Schwierigkeit (3)")
    val imageView = ImageView(Image("/images/logo.png"))
    val vBox = VBox()
    val borderPane = BorderPane()

    init {
        scene = Scene(borderPane, Config.windowSize.first, Config.windowSize.second)
        scene.getStylesheets() += "/common.css"
        scene.getStylesheets() += "/start.css"

        borderPane.styleClass += "border-pane"
        vBox.styleClass += "vbox"
        headerLabel.styleClass += "header-label"
        footerLabel.styleClass += "footer-label"
        difficulty1Button.styleClass += "difficulty-button"
        difficulty2Button.styleClass += "difficulty-button"
        difficulty3Button.styleClass += "difficulty-button"
        imageView.styleClass += "image-view"
        // Nur fuer das Startlogo:
        imageView.fitHeight = 250.0
        imageView.fitWidth = 250.0

        vBox.children.addAll(imageView, difficulty1Button, difficulty2Button, difficulty3Button)

        borderPane.bottom = footerLabel
        borderPane.center = vBox
        borderPane.top = headerView; // headerLabel
        BorderPane.setAlignment(headerView, Pos.BOTTOM_CENTER)
    }

    fun show() {
        Main.stage.title = "Ornithology - das Quiz"
        Main.stage.scene = scene
        Main.stage.show()
    }

}