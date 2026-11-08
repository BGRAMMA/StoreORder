package com.bgramma.storeorder.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bgramma.storeorder.R
import com.bgramma.storeorder.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_layout, MainFragment()).commit()
    }
}