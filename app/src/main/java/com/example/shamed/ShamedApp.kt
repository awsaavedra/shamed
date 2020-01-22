package com.example.shamed

import android.app.Application

// Use this for app-wide runtime configurations for now.
class ShamedApp: Application() {
    companion object {
        val isSignedIn = true
    }
}
