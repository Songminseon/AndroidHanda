package com.example.handa.dataclass

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
data class Post(
        var name: String? = "",
        var point: Int = 0,
        var money: Int = 0
) {

    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "name" to name,
                "point" to point,
                "money" to money
        )
    }
}