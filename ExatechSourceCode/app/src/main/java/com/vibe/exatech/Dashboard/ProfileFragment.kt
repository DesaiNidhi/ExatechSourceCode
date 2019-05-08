package com.vibe.exatech.Dashboard

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import com.vibe.exatech.utils.LogUtils
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment() : Fragment(), DialogInterface.OnClickListener {
    var TAG = javaClass.name
    internal lateinit var view: View
    internal lateinit var photoURI: Uri
    override fun onClick(p0: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> p0!!.dismiss()
        }
    }

    internal lateinit var context: Context
    val REQUEST_FOR_CAMERA = 101
    val REQUEST_FOR_GALLERY = 102
    val REQUEST_PERMISSION_ACESS = 103;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_profile, container, false)
        this.context = getContext()!!
        checkPermission()
        view.img_camera.setOnClickListener(View.OnClickListener {
            openDialog()
        })
        setToolbar()
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).imgBack.setColorFilter(Color.WHITE)
    }

    private fun checkPermission() {
        var permission = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.CAMERA
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
        permission = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
        permission = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.CAMERA),
            REQUEST_PERMISSION_ACESS
        )
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_PERMISSION_ACESS
        )
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_PERMISSION_ACESS
        )
    }

    private fun openDialog() {
        //To change body of created functions use File | Settings | File Templates.
        val builder = AlertDialog.Builder(context)

        var options = Array<CharSequence>(3, { "" })
        options[0] = "Camera"
        options[1] = "Gallery"
        options[2] = "Cancel"
        builder.setTitle("Select Options")
        builder.setItems(options, this)
        builder.show()
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val photoFile = createImageFile()
        photoURI = FileProvider.getUriForFile(context, context.packageName + ".provider", photoFile!!)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(intent, REQUEST_FOR_CAMERA)
    }

    private fun openGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
//        val photoFile = createImageFile()
//        val photoURI = FileProvider.getUriForFile(context, context.packageName + ".provider", photoFile!!)
//        galleryIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(galleryIntent, REQUEST_FOR_GALLERY)
    }

    private fun createImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "ExaTech_Img" + timeStamp + "_"
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        // Save a file: path for use with ACTION_VIEW intents
        return File.createTempFile(
            imageFileName, // prefix
            ".jpg", // suffix
            storageDir      // directory
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_PERMISSION_ACESS -> if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                Log.i(ContentValues.TAG, "Permission has been denied by user")
            } else {
                Log.i(ContentValues.TAG, "Permission has been granted by user")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_FOR_CAMERA ->
                setCameraImage(data)
            REQUEST_FOR_GALLERY ->
                setGalleryImage(data)
        }
    }

    private fun setCameraImage(data: Intent?) {
        if (data != null) {
            val contentURI = photoURI
            view.imgProfile!!.setImageURI(contentURI)
        }
    }

    private fun setGalleryImage(data: Intent?) {
        if (data != null) {
            val contentURI = data!!.data
            try {
                view.imgProfile!!.setImageURI(contentURI)

            } catch (e: IOException) {
                LogUtils.LOGD(TAG, e.message!!)
            }

        }
    }
}



