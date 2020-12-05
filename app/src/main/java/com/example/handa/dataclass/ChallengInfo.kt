package com.example.handa.dataclass

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
data class C_post(
        var title: String? = "",
        var term: Int = 0,
        var remain: Int=0,
        var fee: Int = 0,
        var desc : String?="",
        var auth : String?="",
        var rep : String?="",
        var cat : String?="",
        var t_pat : Int=0,
        var t_fee : Int=0

) {

    // [START post_to_map]
    @Exclude
    fun toMap_c(): Map<String, Any?> {
        return mapOf(
                "title" to title,
                "term" to term,
                "reamin" to remain,
                "fee" to fee,
                "desc" to desc,
                "auth" to auth,
                "rep" to rep,
                "cat" to cat,
                "TotalM" to t_pat,
                "TotalF" to t_fee
                )
    }
}