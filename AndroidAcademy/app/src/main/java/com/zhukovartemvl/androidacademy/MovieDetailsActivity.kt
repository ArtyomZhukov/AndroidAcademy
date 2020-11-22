package com.zhukovartemvl.androidacademy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        findViewById<TextView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

}
