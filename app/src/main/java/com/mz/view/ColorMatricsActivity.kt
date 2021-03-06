package com.mz.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mz.view.customviewtrilogy.R

class ColorMatricsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_matrics)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ColorMatricsActivity::class.java))
        }
    }
}
