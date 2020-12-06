package com.example.handa.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.handa.dataclass.Challenge
import com.example.handa.ChallengeDetail
import com.example.handa.R


class ChallengeAdapter(val context: Context, val challengeList: ArrayList<Challenge>) :
        RecyclerView.Adapter<ChallengeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.challenge_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return challengeList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(challengeList[position], context)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ChallengeDetail::class.java)
            intent.putExtra("item", challengeList[position].title)
            startActivity(holder.itemView.context, intent, null)
            notifyDataSetChanged()
        }

    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Photo = itemView?.findViewById<ImageView>(R.id.PhotoImg)
        val Cat = itemView?.findViewById<TextView>(R.id.category)
        val Title = itemView?.findViewById<TextView>(R.id.Title)
        val Remain = itemView?.findViewById<TextView>(R.id.Remain)
        val Term = itemView?.findViewById<TextView>(R.id.Term)


        fun bind(challenge: Challenge, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (challenge.photo !=null) {
                val bitmap= StringToBitmap(challenge.photo)
                Photo!!.setImageBitmap(bitmap)
            } else {
                Photo?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            Title?.text = challenge.title
            Cat?.text=challenge.Category
            Remain?.text =challenge.RemainDate
            Term?.text = challenge.term

        }
    }
    fun StringToBitmap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte: ByteArray = Base64.decode(encodedString, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.message
            null
        }
    }
}