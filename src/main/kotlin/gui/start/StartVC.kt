package gui.start

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage

class StartVC(val stage: Stage) {

    init {
        StartView.difficulty1Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty2Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty3Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.scene.addEventFilter(KeyEvent.KEY_PRESSED, DifficultyKeyEventHandler())
    }

    inner class DifficultyBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            val difficulty =
                    when (event.source) {
                        StartView.difficulty1Btn -> 1
                        StartView.difficulty2Btn -> 2
                        StartView.difficulty3Btn -> 3
                        else -> return
                    }
            GameVC(stage, difficulty).show()
        }
    }

    inner class DifficultyKeyEventHandler : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            val difficulty =
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
            GameVC(stage, difficulty).show()
        }
    }

    fun show() {
        StartView.show(stage)
    }
}