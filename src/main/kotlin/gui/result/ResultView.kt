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

object ResultView {

    val scene: Scene
    val headerLabel = Label("Ornithology")
    val headerView = ImageView(Image("/images/title.png"))
    val footerLabel = Label("2017, entwickelt für die Schutzstation Wattenmeer Hooge")
    val pointsLabel = Label()
    val onceAgainBtn = Button("Noch einmal spielen (j)")
    val terminateBtn = Button("Beenden (b)")
    val vBox = VBox()
    val borderPane = BorderPane()

    init {
        scene = Scene(borderPane, Config.windowSize.first, Config.windowSize.second)
        scene.getStylesheets() += "/common.css"
        scene.getStylesheets() += "/result.css"

        borderPane.styleClass += "border-pane"
        vBox.styleClass += "vbox"
        headerLabel.styleClass += "header-label"
        footerLabel.styleClass += "footer-label"
        pointsLabel.styleClass += "points-label"

        onceAgainBtn.styleClass += "term-button"
        terminateBtn.styleClass += "term-button"

        vBox.children += pointsLabel
        vBox.children += onceAgainBtn
        vBox.children += terminateBtn

        borderPane.bottom = footerLabel
        borderPane.center = vBox
        borderPane.top = headerView // headerLabel;
        BorderPane.setAlignment(headerView, Pos.TOP_CENTER)
    }

    fun show() {
        Main.stage.title = "Ornithology - Ergebnis"
        Main.stage.scene = scene
        Main.stage.show()
    }

}