package gui.start

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Stage

class GameVC(val stage: Stage) {

    init {
        GameView.weiterButton.setOnAction(WeiterButtonEventHandler())
    }

    inner class WeiterButtonEventHandler: EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            ResultVC(stage).show()
        }
    }

    fun show() {
        GameView.show(stage)
    }

}