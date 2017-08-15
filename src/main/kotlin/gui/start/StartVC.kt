package gui.start

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class StartVC(val stage: Stage) {

    init {
        StartView.weiterButton.setOnAction(WeiterButtonEventHandler())
    }

    inner class WeiterButtonEventHandler: EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            GameVC(stage).show()
        }
    }


    fun show() {
        StartView.show(stage)
    }

}