package com.example.tdm2_tp1_exo1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.activity_some_other.firstActivityBtn
import kotlinx.android.synthetic.main.activity_some_other.secondActivityBtn

class SettingActivity : AppCompatActivity() {

    val shared_pref = "color"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        firstActivityBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivity(intent)
            finish()
        }

        thirdActivityBtn.setOnClickListener {
            val intent = Intent(this, SomeOtherActivity::class.java)
            startActivity(intent)
            finish()
        }


        ArrayAdapter.createFromResource(
            this,
            R.array.color_menu,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            colorPicker.adapter = adapter
        }

        colorPicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                savePref(position)
            }
        }

    }

    fun savePref(index : Int){
        val pref = getSharedPreferences("PREF",Context.MODE_PRIVATE)
        val editor = pref.edit()

        var color = getColorByIndex(index)

        editor.putInt(shared_pref, color)

        Log.i("saved color", color.toString())

        editor.commit()

        var test = pref.getInt(shared_pref, R.color.white)

        Log.i("savedtest color", test.toString())
    }

    fun getColorByIndex(index : Int) : Int{

        return when(index){
            0 -> R.color.white
            1 -> R.color.blue
            2 -> R.color.red
            3 -> R.color.green
            4 -> R.color.yellow
            else -> R.color.white
        }

    }

}
