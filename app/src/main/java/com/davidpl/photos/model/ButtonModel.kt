package com.davidpl.photos.model

data class ButtonModel(
        var title: Int,
        var endIcon: Int? = null,
        var onClick: () -> Unit
)