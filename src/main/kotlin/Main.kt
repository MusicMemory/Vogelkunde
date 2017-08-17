import gui.start.GameView
import gui.start.ResultView
import gui.start.StartVC
import gui.start.StartView
import javafx.application.Application
import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {
        StartView.stage  = primaryStage
        GameView.stage   = primaryStage
        ResultView.stage = primaryStage
        StartVC.show()
    }
}

fun main(args : Array<String>) {
    Application.launch(Main::class.java, *args)
}