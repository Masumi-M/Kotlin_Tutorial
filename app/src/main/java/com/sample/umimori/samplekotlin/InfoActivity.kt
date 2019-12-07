package com.sample.umimori.samplekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent: Intent = getIntent()
        val message: String = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
        val textView: TextView = findViewById<TextView>(R.id.text_info)
        textView.setText(message)
    }
}
