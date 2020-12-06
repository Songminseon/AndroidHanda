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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.handa.ChallengeDetail
import com.example.handa.FinishChallenge
import com.example.handa.R
import com.example.handa.dataclass.Certify


class CertifyAdapter(val context: Context, val certifyList: ArrayList<Certify>) :
        RecyclerView.Adapter<CertifyAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.certify_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return certifyList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(certifyList[position], context)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, FinishChallenge::class.java)
            intent.putExtra("item", certifyList[position].c_title)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
            notifyDataSetChanged()
        }

    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Photo = itemView?.findViewById<ImageView>(R.id.c_image)
        val Title = itemView?.findViewById<TextView>(R.id.c_title)
        val cat= itemView?.findViewById<TextView>(R.id.c_category)
        val Remain = itemView?.findViewById<TextView>(R.id.c_remain)

        fun bind(certify: Certify, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (certify.c_image !=null) {
                val bitmap= StringToBitmap(certify.c_image)
                Photo!!.setImageBitmap(bitmap)
            } else {
                Photo?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            Title?.text = certify.c_title
            cat?.text=certify.c_cat
            Remain?.text =certify.c_remain
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




}