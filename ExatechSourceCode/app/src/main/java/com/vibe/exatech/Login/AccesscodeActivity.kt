package com.vibe.exatech.Login

import android.annotation.TargetApi
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import com.vibe.exatech.utils.Const
import kotlinx.android.synthetic.main.access_code_keyboard.*
import kotlinx.android.synthetic.main.activity_accesscode.*
import kotlinx.android.synthetic.main.row_my_orders.*
import kotlinx.android.synthetic.main.toolbar.*

class AccesscodeActivity : AppCompatActivity(), View.OnClickListener {
    var counter = 0
    var accessCode = ""
    var previousAccessCode = ""
    var scrTag = 0
    var isNew = false
    var isConfirmed = false
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn1) {
            accessCode = accessCode + "1"
            incrementCountr()
            checkRadiobutton()

        }
        if (p0?.id == R.id.btn2) {
            accessCode = accessCode + "2"
            incrementCountr()
            checkRadiobutton()

        }
        if (p0?.id == R.id.btn3) {
            accessCode = accessCode + "3"
            incrementCountr()
            checkRadiobutton()

        }
        if (p0?.id == R.id.btn4) {
            accessCode = accessCode + "4"
            incrementCountr()
            checkRadiobutton()

        }
        if (p0?.id == R.id.btn5) {
            accessCode = accessCode + "5"
            incrementCountr()
            checkRadiobutton()

        }
        if (p0?.id == R.id.btn6) {
            accessCode = accessCode + "6"
            incrementCountr()
            checkRadiobutton()
        }
        if (p0?.id == R.id.btn7) {
            accessCode = accessCode + "7"
            incrementCountr()
            checkRadiobutton()
        }
        if (p0?.id == R.id.btn8) {
            accessCode = accessCode + "8"
            incrementCountr()
            checkRadiobutton()
        }
        if (p0?.id == R.id.btn9) {
            accessCode = accessCode + "9"
            incrementCountr()
            checkRadiobutton()
        }
        if (p0?.id == R.id.btn0) {
            accessCode = accessCode + "0"
            incrementCountr()
            checkRadiobutton()
        }
        if (p0?.id == R.id.imgDelete) {
            if (counter > 0) {
                counter--
                resetRadioBtn()
            }


        }
        if (p0?.id == R.id.imgFilter) {
            finish()
            overridePendingTransition(R.anim.no_change, R.anim.slide_down)
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesscode)

        if (intent.getIntExtra(Const.scrTag, 0) != null) {
            scrTag = intent.getIntExtra(Const.scrTag, 0)
            if (scrTag == Const.scrSettingsTag) {
                txtForgot.visibility = View.GONE
                txtEnter.setText(getString(R.string.enter_current_access_code))
                imgFilter.visibility = View.VISIBLE
                imgFilter.setImageDrawable(getDrawable(R.drawable.img_close))

            }
        }
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        imgFilter.setOnClickListener(this)
        imgDelete.setOnClickListener(this)

    }

    fun checkRadiobutton() {
        if (counter == 1) {
            radioBtn1.isChecked = true
        }
        if (counter == 2) {
            radioBtn2.isChecked = true
        }
        if (counter == 3) {
            radioBtn3.isChecked = true
        }
        if (counter == 4) {
            radioBtn4.isChecked = true
        }
        if (counter == 5) {
            radioBtn5.isChecked = true
        }
        if (counter == 6) {
            radioBtn6.isChecked = true
        }

    }

    fun incrementCountr() {
        if (counter != 6)
            counter++
        if (counter == 6) {
            if (scrTag == Const.scrSettingsTag) {
                if (isConfirmed && isNew) {
                    if (accessCode.equals(previousAccessCode))
                    {
                        onBackPressed()

                    }
                    else
                    {
                        Snackbar.make(relativeMain,"Please Confirm Access Code",Snackbar.LENGTH_SHORT).show()
                    }
                } else if (isNew) {
                    previousAccessCode = accessCode
                    txtEnter.setText(getString(R.string.confirm_new_access_code))
                    isConfirmed = true
                    clearData()
                }  else {
                    checkcurrentCode()
                }

            } else {
                val intent = Intent(this, DrawerActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Access Code:  " + accessCode, Toast.LENGTH_LONG).show()
            }

        }

    }

    fun checkcurrentCode() {
        if (accessCode.equals("222222")) {
            isNew = true
            txtEnter.setText(getString(R.string.enter_new_access_code))
            clearData()
        }
    }

    fun resetRadioBtn() {
        if (radioBtn6.isChecked) {
            radioBtn6.isChecked = false
        } else if (radioBtn5.isChecked) {
            radioBtn5.isChecked = false
        } else if (radioBtn4.isChecked) {
            radioBtn4.isChecked = false
        } else if (radioBtn3.isChecked) {
            radioBtn3.isChecked = false
        } else if (radioBtn2.isChecked) {
            radioBtn2.isChecked = false
        } else if (radioBtn1.isChecked) {
            radioBtn1.isChecked = false
        }
        accessCode = accessCode.substring(0, accessCode.length - 1)
    }

    override fun onResume() {
        super.onResume()
        clearData()

    }

    private fun clearData() {
        counter = 0
        radioBtn1.isChecked = false
        radioBtn2.isChecked = false
        radioBtn3.isChecked = false
        radioBtn4.isChecked = false
        radioBtn5.isChecked = false
        radioBtn6.isChecked = false
        accessCode = ""


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.no_change, R.anim.slide_down);

    }
}