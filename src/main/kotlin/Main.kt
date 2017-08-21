import gui.start.StartController
import javafx.application.Application
import javafx.stage.Stage

class Main: Application() {

    companion object {
        lateinit var stage: Stage
    }

    override fun start(primaryStage: Stage) {
        stage = primaryStage
        stage.setResizable(false)
        StartController.show()
    }
}

fun main(args : Array<String>) {
    Application.launch(Main::class.java, *args)
}