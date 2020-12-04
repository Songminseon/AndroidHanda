package com.example.handa.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.create_seventh.*
import kotlinx.android.synthetic.main.create_seventh.view.*
import java.lang.Exception

class CreateSeventh : Fragment() {

    private val OPEN_GALLERY=1
    private var fbStorage : FirebaseStorage?= null
    private lateinit var auth: FirebaseAuth
    private var reg_image: Uri? =null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.create_seventh, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fbStorage =FirebaseStorage.getInstance()

        auth=FirebaseAuth.getInstance()

        view.photo_btn.setOnClickListener{
            openGallery()
        }
        view.CreateFinish.setOnClickListener{
            var inFileName = "IMAGE_"+auth.currentUser?.uid+"_.png"
            var storageRef = fbStorage?.reference?.child("images")?.child(inFileName)
            storageRef?.putFile(reg_image!!)
            view.findNavController().navigate(R.id.action_createSeventh_to_CreateMain)

        }
    }

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent,OPEN_GALLERY)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUrl : Uri = data?.data!!
                reg_image=currentImageUrl
                try{
                    val bitmap=MediaStore.Images.Media.getBitmap(requireContext().contentResolver,currentImageUrl)
                    Rep_photo.setImageBitmap(bitmap)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            else{
                Log.d("ActivityResult","something wrong")
            }
        }
    }
}