import javafx.application.Application
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import tornadofx.*

class Sample01TornadoFXApp : App(Sample01View::class)

class Sample01View : View("Sample 01 TornadoFX") {
    override val root =
            borderpane {
                prefWidth = 400.0
                prefHeight = 200.0

                center {
                    button("Click Me") {
                        setOnAction {
                            alert(Alert.AlertType.INFORMATION,
                                    "Sample 01 TornadoFX",
                                    "Button Clicked",
                                    ButtonType.OK)
                        }
                    }
                }
            }
}

fun main(args: Array<String>) {
    Application.launch(Sample01TornadoFXApp::class.java, *args)
}