package com.example.tdm2_tp1_exo1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.activity_secondary.settingBtn
import kotlinx.android.synthetic.main.activity_secondary.thirdActivtyBtn

class SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val shared_pref = "color"
        val pref = getSharedPreferences("PREF",Context.MODE_PRIVATE)
        val color = pref.getInt(shared_pref, R.color.white)

        Log.i("saved color got", color.toString())

        secondActivityLayout.setBackgroundColor(ContextCompat.getColor(this, color))

        firstActivityBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        thirdActivtyBtn.setOnClickListener {
            val intent = Intent(this, SomeOtherActivity::class.java)
            startActivity(intent)
            finish()
        }

        settingBtn.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
