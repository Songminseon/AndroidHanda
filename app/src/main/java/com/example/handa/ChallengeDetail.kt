package com.example.handa

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64

import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.challenge_detail.*

class ChallengeDetail : AppCompatActivity() {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var item: String = ""
    var total_M:Int=0
    var total_F:Int=0
    var fee:Int=0

    var uid:String=""
    var num:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge_detail)

        item = intent.extras!!.get("item") as String
        val data_c = database.getReference("userChallenge")
        data_c.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    for (j in i.children) {
                        if (j.child("title").value.toString() == item) {
                            uid=i.key.toString()
                            num= j.key.toString()
                            d_title.text = j.child("title").value.toString()
                            d_cat.text = j.child("cat").value.toString()
                            d_term.text = j.child("term").value.toString()
                            d_fee.text = j.child("fee").value.toString()
                            fee=j.child("fee").value.toString().toInt()
                            d_TotalM.text = j.child("TotalM").value.toString()
                            total_M=j.child("TotalM").value.toString().toInt()
                            d_TotalF.text = j.child("TotalF").value.toString()
                            total_F=j.child("TotalM").value.toString().toInt()
                            d_desc.text = j.child("desc").value.toString()
                            d_auth.text = j.child("auth").value.toString()
                            if (j.child("rep").value.toString() !=null) {
                                val bitmap= StringToBitmap(j.child("rep").value.toString())
                                d_image.setImageBitmap(bitmap)
                            } else {
                                d_image.setImageResource(R.mipmap.ic_launcher)
                            }

                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        d_pat.setOnClickListener{
            total_M+=1
            total_F+=fee
            data_c.child(uid).child(num).child("totalF").setValue(total_F.toString())
            data_c.child(uid).child(num).child("totalM").setValue(total_M.toString())
            finish()
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