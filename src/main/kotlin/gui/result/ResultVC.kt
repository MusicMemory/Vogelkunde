package gui.start

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage

class ResultVC(val stage: Stage, points: Int) {

    init {
        ResultView.pointsLbl.text = "Sie haben $points Punkte erreicht"
        ResultView.onceAgainBtn.setOnAction(OnceAgainBtnEventHandler())
        ResultView.terminateBtn.setOnAction(TerminateBtnEventHandler())
        ResultView.scene.addEventFilter(KeyEvent.KEY_PRESSED, KeyEventHandler())
    }

    inner class OnceAgainBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            StartVC(stage).show()
        }
    }

    inner class TerminateBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            Platform.exit()
        }
    }

    inner class KeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            when (event.code) {
                KeyCode.J -> StartVC(stage).show()
                KeyCode.N,
                KeyCode.ESCAPE -> Platform.exit()
                else -> return
            }
        }
    }

    fun show() {
        ResultView.show(stage)
    }

}


