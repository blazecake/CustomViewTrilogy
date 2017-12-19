package com.mz.view.customviewtrilogy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mz.view.ColorMatricsActivity
import com.mz.view.PaintActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPaintBtn.setOnClickListener { PaintActivity.start(this) }
        mainMatricsBtn.setOnClickListener { ColorMatricsActivity.start(this) }
    }
}
