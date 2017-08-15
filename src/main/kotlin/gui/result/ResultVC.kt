package gui.start

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class ResultVC(val stage: Stage) {

    init {
        ResultView.weiterButton.setOnAction(WeiterButtonEventHandler())
    }

    inner class WeiterButtonEventHandler: EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            StartVC(stage).show()
        }
    }


    fun show() {
        ResultView.show(stage)
    }

}