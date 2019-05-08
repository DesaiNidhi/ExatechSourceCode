package com.vibe.exatech.Login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.vibe.exatech.R
import com.vibe.exatech.utils.Pref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnNxt) {
           if(isValid())
           {
               Pref.setValue(this,Pref.IS_FIRST_TIME,true)
               var intent = Intent(this, AccesscodeActivity::class.java)
               startActivity(intent)
           }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnNxt.setOnClickListener(this)
    }
    fun isValid():Boolean
    {
        if(TextUtils.isEmpty(edtPhoneNumber.text.toString()))
        {
            return false
        }
        return true
    }
}