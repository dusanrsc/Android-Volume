package com.infinitysoftware.volume

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        // Volume Settings.
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        // val halfVolume = (audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 2)
        // val minVolume = 0

        val increaseBy3 = (currentVolume + 3).coerceAtMost(maxVolume)
        // val decreaseBy3 = (currentVolume - 3).coerceAtMost(maxVolume)

        // Or 'currentVolume' For Current Volume.

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, increaseBy3, AudioManager.FLAG_SHOW_UI)

        finish()
    }
}
