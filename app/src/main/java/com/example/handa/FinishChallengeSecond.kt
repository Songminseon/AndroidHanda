package com.example.handa


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.handa.`object`.CreateC
import com.example.handa.`object`.Finish
import com.example.handa.dataclass.C_post
import com.example.handa.dataclass.FinishData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.finish_second.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class FinishChallengeSecond : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var currentPhotoPath : String
    private var image:String=""
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var auth: FirebaseAuth
    private var num: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finish_second)
        settingPermission()

        capture_f.setOnClickListener{
            settingPermission()
            startCapture()
        }
        Enter.setOnClickListener{
            val com=comment.text.toString()
            Finish.finish_list.add(FinishData(image,com))
            count_li()
            enter_data()
            finish()
        }
    }
    fun enter_data(){
        val user = auth.currentUser
        val DatabaseReference = database.reference
        val data = C_post(CreateC.title, CreateC.term, CreateC.term, CreateC.fee, CreateC.desc, CreateC.auth, CreateC.rep, CreateC.cat, 0, 0)
        val info = data.toMap_c()
        num += 1
        DatabaseReference.child("userChallengeImage").child(user?.uid.toString()).child(num.toString()).setValue(info)
    }
    fun count_li() {
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val data = database.getReference("userChallenge")
        data.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    if (i.key == user!!.uid) {
                        for (j in i.children) {
                            num += 1
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun settingPermission(){
        var permis = object  : PermissionListener{
            //            어떠한 형식을 상속받는 익명 클래스의 객체를 생성하기 위해 다음과 같이 작성
            override fun onPermissionGranted() {
                Toast.makeText(this@FinishChallengeSecond, "권한 허가", Toast.LENGTH_SHORT)
                        .show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@FinishChallengeSecond, "권한 거부", Toast.LENGTH_SHORT)
                        .show()
                ActivityCompat.finishAffinity(this@FinishChallengeSecond) // 권한 거부시 앱 종료
            }
        }

        TedPermission.with(this)
                .setPermissionListener(permis)
                .setRationaleMessage("카메라 사진 권한 필요")
                .setDeniedMessage("카메라 권한 요청 거부")
                .setPermissions(
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.CAMERA)
                .check()
    }


    fun startCapture(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try{
                    createImageFile()
                }catch(ex:IOException){
                    null
                }
                photoFile?.also{
                    val photoURI : Uri = FileProvider.getUriForFile(
                            this,
                            "com.example.handa.provider",
                            it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
    @Throws(IOException::class)
    private fun createImageFile() : File{
        val timeStamp : String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir : File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
        ).apply{
            currentPhotoPath = absolutePath
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val bitmap = BitmapFactory.decodeFile(currentPhotoPath)
            lateinit var exif : ExifInterface

            try{
                exif = ExifInterface(currentPhotoPath)
                var exifOrientation = 0
                var exifDegree = 0

                if (exif != null) {
                    exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_NORMAL)
                    exifDegree = exifOrientationToDegress(exifOrientation)
                }
                // image 넣는다
                finish_img.setImageBitmap((rotate(bitmap, exifDegree)))
                image=BitmapToString((rotate(bitmap, exifDegree))).toString()
            }catch (e : IOException){
                e.printStackTrace()
            }

        }
    }

    private fun exifOrientationToDegress(exifOrientation: Int): Int {
        when(exifOrientation){
            ExifInterface.ORIENTATION_ROTATE_90 ->{
                Log.d("rotate","rotate90")
                return 90
            }
            ExifInterface.ORIENTATION_ROTATE_180 -> {
                Log.d("rotate","rotate180")
                return 180
            }
            ExifInterface.ORIENTATION_ROTATE_270 ->{
                Log.d("rotate","rotate270")
                return 270
            }
            else -> {
                Log.d("rotate","rotate0")
                return 0
            }

        }
    }

    private fun rotate(bitmap: Bitmap, degree: Int) : Bitmap {
        Log.d("rotate","init rotate")
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix,true)
    }

    fun BitmapToString(bitmap: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos)
        val bytes: ByteArray = baos.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

}