package com.example.handa

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
data class Post(
    var name: String?=""
) {

    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, String?> {
        return mapOf(
            "name" to name
        )
    }
}