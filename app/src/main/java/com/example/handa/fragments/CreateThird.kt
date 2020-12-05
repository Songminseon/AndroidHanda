package com.example.handa.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.handa.R
import com.example.handa.`object`.CreateC
import kotlinx.android.synthetic.main.create_third.*
import java.io.ByteArrayOutputStream


class CreateThird : Fragment() {

    private val OPEN_GALLERY= 1
    private lateinit var img: Bitmap

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.create_third, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        uploadButton.setOnClickListener{
            openGallery()

        }

        submitButton.setOnClickListener{
            CreateC.title = title_3.text.toString()
            CreateC.auth = auth_3.text.toString()
            CreateC.desc = desc_3.text.toString()
            CreateC.rep= BitmapToString(img).toString()
            view.findNavController().navigate(R.id.action_createThird_to_createFourth)

        }
    }
    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUri: Uri = data?.data!!

                try{
                    val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, currentImageUri)
                    img=bitmap
                    RePhoto.setImageBitmap(bitmap)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        else{
            Log.d("ActivityResult", "something wrong")
        }
    }
    fun BitmapToString(bitmap: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos)
        val bytes: ByteArray = baos.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    }

