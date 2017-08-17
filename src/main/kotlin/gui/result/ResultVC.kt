package gui.result

import domain.PlayerData
import gui.start.ResultView
import gui.start.StartVC
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

object ResultVC {

    init {
        ResultView.onceAgainBtn.setOnAction(OnceAgainBtnEventHandler())
        ResultView.terminateBtn.setOnAction(TerminateBtnEventHandler())
        ResultView.scene.addEventFilter(KeyEvent.KEY_PRESSED, KeyEventHandler())
    }

    class OnceAgainBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            StartVC.show()
        }
    }

    class TerminateBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            Platform.exit()
        }
    }

    class KeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            when (event.code) {
                KeyCode.J -> StartVC.show()
                KeyCode.N,
                KeyCode.ESCAPE -> Platform.exit()
                else -> return
            }
        }
    }

    fun show() {
        ResultView.pointsLbl.text = "Sie haben ${PlayerData.points} Punkte erreicht"
        ResultView.show()
    }

}