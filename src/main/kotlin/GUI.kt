import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.stage.Stage
import javafx.scene.paint.Color
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent


class GUI: Application() {

    override fun start(stage: Stage) {

        val pane = StackPane()
        pane.setBackground(Background(BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)))
        val image = Image("images/alpenstrandlaeufer_01.jpg")
        val imageView = ImageView(image);
        pane.children.add(imageView)
        StackPane.setAlignment(imageView, Pos.TOP_CENTER)

        val borderPane = BorderPane()
        borderPane.center = pane
        val hBox = HBox()
        hBox.children.add(Label("Ornithology"))
        borderPane.top = hBox
        val scene = Scene(borderPane, 400.0, 400.0)
        scene.addEventFilter(KeyEvent.KEY_PRESSED) { ke ->
            if (ke.code == KeyCode.ESCAPE) {
                println("Key Pressed: " + ke.code)
                ke.consume() // <-- stops passing the event to next node
            }
        };
        stage.scene = scene
        stage.show()
    }
}

fun main(args : Array<String>) {
    Application.launch(GUI::class.java, *args)
}