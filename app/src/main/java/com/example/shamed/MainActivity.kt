package com.example.shamed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shamed.ui.main.SignUpFragment
import com.facebook.stetho.Stetho

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_user_input)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment.newInstance())
                .commitNow()
        }

        Stetho.initializeWithDefaults(this);
    }
}