package com.example.shamed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shamed.ui.main.MainFragment
import com.facebook.stetho.Stetho

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        Stetho.initializeWithDefaults(this);
    }
}