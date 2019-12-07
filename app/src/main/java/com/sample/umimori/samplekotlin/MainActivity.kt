package com.sample.umimori.samplekotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE: String = "com.sample.umimori.samplekotlin"

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                change_text.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                change_text.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                change_text.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Change the text of textView when the button pressed
        val textView = findViewById<TextView>(R.id.change_text) as TextView
        val button = findViewById<Button>(R.id.change_button) as Button

        textView.text = "Before"
        button.setOnClickListener{ v->
            textView.text = "After"
        }


    }


    fun openInfo(view: View){
        val intent: Intent = Intent(this@MainActivity,InfoActivity::class.java)
        val editText: EditText = findViewById(R.id.editText) as EditText
        val message: String = editText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}
