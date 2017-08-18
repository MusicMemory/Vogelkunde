package gui.result

import domain.PlayerData
import gui.start.ResultView
import gui.start.StartController
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

object ResultController {

    init {
        ResultView.onceAgainBtn.setOnAction(OnceAgainBtnEventHandler())
        ResultView.terminateBtn.setOnAction(TerminateBtnEventHandler())
        ResultView.scene.addEventFilter(KeyEvent.KEY_PRESSED, KeyEventHandler())
    }

    class OnceAgainBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            StartController.show()
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
                KeyCode.J, KeyCode.Y
                -> StartController.show()
                KeyCode.B, KeyCode.N,
                KeyCode.ESCAPE -> Platform.exit()
                else -> return
            }
        }
    }

    fun show() {
        val pointText = when (PlayerData.points) {
            0 -> "keinen Punkt"
            1 -> "einen Punkt"
            else -> "${PlayerData.points} Punkte"
        }

        ResultView.pointsLabel.text = "Sie haben ${pointText} erreicht."
        ResultView.show()
    }

}