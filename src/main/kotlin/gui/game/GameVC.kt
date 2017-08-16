package gui.start

import domain.BirdRepository
import domain.Config
import domain.Game
import domain.ImageRepository
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.stage.Stage

class GameVC(val stage: Stage, val difficulty: Int) {

    val game = Game(BirdRepository.noBirds(), Config.noQuestion , Config.noAnswers, difficulty);
    var counter = 0

    init {
        GameView.answer1Btn.setOnAction(WeiterButtonEventHandler())
        GameView.setImage(chooseImage(counter++))
    }

    inner class WeiterButtonEventHandler: EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            if (counter >= Config.noQuestion) {
                ResultVC(stage).show()
            }
            else {
                GameView.setImage(chooseImage(counter++))
            }
        }
    }

    private fun chooseImage(q: Int): Image {
        val birdId = game.questions[q]
        val bird = BirdRepository.birdWithId(birdId)
        return ImageRepository.imageWithFileName(bird.filename)
    }

    fun show() {
        GameView.show(stage)
    }

}