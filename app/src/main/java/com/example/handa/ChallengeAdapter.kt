package com.example.handa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.challenge_item.view.*


class ChallengeAdapter(val context: Context, val challengeList:ArrayList<Challenge>) :
        RecyclerView.Adapter<ChallengeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.challenge_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return challengeList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(challengeList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Photo = itemView?.findViewById<ImageView>(R.id.PhotoImg)
        val Title = itemView?.findViewById<TextView>(R.id.Title)
        val Remain = itemView?.findViewById<TextView>(R.id.Remain)
        val Term = itemView?.findViewById<TextView>(R.id.Term)

        fun bind (challenge: Challenge, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (challenge.photo != "") {
                val resourceId = context.resources.getIdentifier(challenge.photo, "drawable", context.packageName)
                Photo?.setImageResource(resourceId)
            } else {
                Photo?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            Title?.text = challenge.title
            Remain?.text =challenge.RemainDate
            Term?.text = challenge.term
        }
    }


}