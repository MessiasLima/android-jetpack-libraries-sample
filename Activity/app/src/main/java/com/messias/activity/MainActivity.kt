package com.messias.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {

    // The Activity KTX adds this view model lazy dispatcher
    private val sampleViewModel by viewModels<VM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The Activity KTX adds this implementation of addCallback that returns the callback
        val callback = onBackPressedDispatcher.addCallback(this, sampleViewModel.callbackEnabled) {
            createDialog(this)
        }
    }

    class VM : ViewModel() {
        val callbackEnabled = true

        init {
            Log.i("View model", "View Model Created")
        }
    }

    private fun createDialog(cb: OnBackPressedCallback) {
        AlertDialog.Builder(this@MainActivity)
            .setTitle("Custom title")
            .setMessage("Are you sure you want to exit?")
            .setNeutralButton("cancel", null)
            .setPositiveButton("Yes, take me out when I click back again") { _, _ ->
                cb.isEnabled = false
            }
            .create()
            .show()
    }
}