package com.vibe.exatech

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.vibe.exatech.Login.AccesscodeActivity
import com.vibe.exatech.Login.LoginActivity
import com.vibe.exatech.utils.Pref

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val mContext = this
        Handler().postDelayed({
            if (!Pref.getValue(this, Pref.IS_FIRST_TIME, false)) {
                startActivity(Intent(mContext, LoginActivity::class.java))

            } else {

                startActivity(Intent(mContext, AccesscodeActivity::class.java))
                overridePendingTransition(R.anim.slide_up, R.anim.no_change);
            }
        }, 3000)
    }
}