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

    val game = Game(BirdRepository.noBirds(), Config.noQuestions, Config.noAnswers, difficulty);
    var qCnt = 0

    init {
        GameView.answerBtns.forEach { it.setOnAction(WeiterButtonEventHandler()) }
        GameView.setImage(chooseImage(qCnt++))
    }

    inner class WeiterButtonEventHandler: EventHandler<ActionEvent> {
        override fun handle(event: ActionEvent) {
            if (qCnt >= Config.noQuestions) {
                ResultVC(stage, game.points).show()
            }
            else {
                val bntIdx = GameView.answerBtns.indexOf(event.source)
                if (game.isCorrect(qCnt, bntIdx)) {
                    game.addPoints(difficulty)
                }
                GameView.setImage(chooseImage(qCnt++))
            }
        }
    }

    /**
     * Ermittelt das Bild zur q-ten Frage
     */
    private fun chooseImage(q: Int): Image {
        val birdId = game.questions[q]
        val bird = BirdRepository.birdWithId(birdId)
        return ImageRepository.imageWithFileName(bird.filename)
    }

    fun show() {
        GameView.show(stage)
    }

}