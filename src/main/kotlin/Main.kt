import gui.start.GameView
import gui.start.ResultView
import gui.start.StartController
import gui.start.StartView
import javafx.application.Application
import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.setResizable(false)
        StartView.stage  = primaryStage
        GameView.stage   = primaryStage
        ResultView.stage = primaryStage
        StartController.show()
    }
}

fun main(args : Array<String>) {
    Application.launch(Main::class.java, *args)
}