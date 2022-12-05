package com.example.kotlinbaseproject.activity

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * This class is extended by all application activities
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun setContentView(view: View?) {
        super.setContentView(view)
        init()
    }

    /**
     * This method is used to initialization process of activity
     */
    abstract fun init()
}