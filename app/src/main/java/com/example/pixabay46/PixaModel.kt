package com.example.pixabay46

data class PixaModel(
    val hits:List<ImageModel>
)

data class ImageModel (
    val largeImageURL: String
        )
