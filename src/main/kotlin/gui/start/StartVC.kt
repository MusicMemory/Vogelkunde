package gui.start

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class StartVC(val stage: Stage) {

    init {
        StartView.difficulty1Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty2Btn.setOnAction(DifficultyBtnEventHandler())
        StartView.difficulty3Btn.setOnAction(DifficultyBtnEventHandler())
    }

    inner class DifficultyBtnEventHandler : EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            val difficulty =
                    when (event.source) {
                        StartView.difficulty1Btn -> 1
                        StartView.difficulty2Btn -> 2
                        StartView.difficulty3Btn -> 3
                        else -> 1
                    }
            GameVC(stage, difficulty).show()
        }
    }

    fun show() {
        StartView.show(stage)
    }
}