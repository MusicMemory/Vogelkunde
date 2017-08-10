package domain

import javafx.scene.image.Image

object ImageRepository {

    fun getImageByFileName(fileName: String): Image? {
        return Image(fileName)
    }

}