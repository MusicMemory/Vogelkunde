package gui.start

import domain.PlayerData
import gui.game.GameController
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

object StartController {

    init {
        StartView.difficulty1Button.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty2Button.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty3Button.setOnAction(DifficultyBtnEventHandler())
        StartView.scene.addEventFilter(KeyEvent.KEY_PRESSED, DifficultyKeyEventHandler())
    }

    class DifficultyBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            PlayerData.assignDifficulty(
                    when (event.source) {
                        StartView.difficulty1Button -> 1
                        StartView.difficulty2Button -> 2
                        StartView.difficulty3Button -> 3
                        else -> return
                    })
            GameController.show()
        }
    }

    class DifficultyKeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            PlayerData.assignDifficulty(
                    when (event.code) {
                        KeyCode.DIGIT1 -> 1
                        KeyCode.DIGIT2 -> 2
                        KeyCode.DIGIT3 -> 3
                        KeyCode.ESCAPE -> {
                            Platform.exit()
                            return
                        }
                        else -> return
                    })
            GameController.show()
        }
    }

    fun show() {
        PlayerData.points = 0
        StartView.show()
    }
}