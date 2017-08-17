package gui.start

import domain.PlayerData
import gui.game.GameVC
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

object StartVC {

    init {
        StartView.difficulty1Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty2Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty3Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.scene.addEventFilter(KeyEvent.KEY_PRESSED, DifficultyKeyEventHandler())
    }

    class DifficultyBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            PlayerData.difficulty =
                    when (event.source) {
                        StartView.difficulty1Btn -> 1
                        StartView.difficulty2Btn -> 2
                        StartView.difficulty3Btn -> 3
                        else -> return
                    }
            GameVC.show()
        }
    }

    class DifficultyKeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            PlayerData.difficulty =
                    when (event.code) {
                        KeyCode.DIGIT1 -> 1
                        KeyCode.DIGIT2 -> 2
                        KeyCode.DIGIT3 -> 3
                        KeyCode.ESCAPE -> {
                            Platform.exit()
                            return
                        }
                        else -> return
                    }
            GameVC.show()
        }
    }

    fun show() {
        PlayerData.points = 0
        StartView.show()
    }
}