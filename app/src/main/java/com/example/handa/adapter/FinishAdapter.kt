package com.example.handa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handa.dataclass.Finish
import com.example.handa.R


class FinishAdapter(val context: Context, val finishList: ArrayList<Finish>) :
    RecyclerView.Adapter<FinishAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.finish_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return finishList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(finishList[position], context)

    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Photo = itemView?.findViewById<ImageView>(R.id.f_image)
        val Comment = itemView?.findViewById<TextView>(R.id.f_comment)


        fun bind(finish: Finish, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
            이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (finish.f_photo != "") {
                val resourceId = context.resources.getIdentifier(finish.f_photo, "drawable", context.packageName)
                Photo?.setImageResource(resourceId)
            } else {
                Photo?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            Comment?.text=finish.comment
        }
    }


}