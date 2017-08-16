package gui.start

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ResultVC(val stage: Stage) {

    init {
        ResultView.onceAgainBtn.setOnAction(OnceAgainBtnEventHandler())
        ResultView.terminateBtn.setOnAction(TerminateBtnEventHandler())
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


    fun show() {
        ResultView.show(stage)
    }

}