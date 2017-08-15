import gui.start.StartVC
import javafx.application.Application
import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {
        StartVC(primaryStage).show()
    }

}

fun main(args : Array<String>) {
    Application.launch(Main::class.java, *args)
}