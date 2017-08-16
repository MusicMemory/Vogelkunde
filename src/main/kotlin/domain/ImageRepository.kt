package domain

import javafx.scene.image.Image

object ImageRepository {

    fun imageWithFileName(fileName: String): Image {
        return Image("/images/" + fileName)
    }

}