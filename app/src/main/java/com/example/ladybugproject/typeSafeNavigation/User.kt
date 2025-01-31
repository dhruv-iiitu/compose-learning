package com.example.ladybugproject.typeSafeNavigation

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: Int,
    val name: String
)
