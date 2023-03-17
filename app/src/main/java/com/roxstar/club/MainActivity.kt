package com.roxstar.club

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.view.View
import com.roxstar.club.Music.mediaplayer_music
import com.roxstar.club.Music.mediaplayer_sounds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaplayer_music = MediaPlayer.create(this,R.raw.music)
        mediaplayer_sounds = MediaPlayer.create(this, R.raw.click)

        cons_settings.setOnClickListener {

        }

        button3.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                mediaplayer_sounds!!.start()
            }
            settings.visibility = View.GONE
        }

        imageView14.setOnClickListener {
            val music = PreferenceManager.getDefaultSharedPreferences(this).getInt("music", 1)
            if(music == 1){
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("music", 0).apply()
                mediaplayer_music!!.pause()
                val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
                if(volume == 1){
                    mediaplayer_sounds!!.start()
                }
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("music", 1).apply()
                mediaplayer_music!!.start()
                mediaplayer_music!!.isLooping = true
                val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
                if(volume == 1){
                    mediaplayer_sounds!!.start()
                }
            }
        }

        imageView13.setOnClickListener {
            val vibration = PreferenceManager.getDefaultSharedPreferences(this).getInt("vibration", 1)
            if(vibration == 1){
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("vibration", 0).apply()
                val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
                if(volume == 1){
                    mediaplayer_sounds!!.start()
                }
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("vibration", 1).apply()
                val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
                if(volume == 1){
                    mediaplayer_sounds!!.start()
                }
            }
        }

        imageView15.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("volume", 0).apply()
            }else{
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("volume", 1).apply()
                if(volume == 1){
                    mediaplayer_sounds!!.start()
                }
            }
        }

        button.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                mediaplayer_sounds!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this, SlotGamesActivity1::class.java))
        }

        button2.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                mediaplayer_sounds!!.start()
            }
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("onStops", 1).apply()
            startActivity(Intent(this, SlotGamesActivity2::class.java))
        }

        imageView9.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                mediaplayer_sounds!!.start()
            }
            settings.visibility = View.VISIBLE
        }

        settings.setOnClickListener {
            val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
            if(volume == 1){
                mediaplayer_sounds!!.start()
            }
            settings.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        val musics = PreferenceManager.getDefaultSharedPreferences(this).getInt("music", 1)
        if(musics == 1){
            mediaplayer_music!!.start()
            mediaplayer_music!!.isLooping = true
        }else{

        }
        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            }, 1000)
    }

    override fun onStop() {
        super.onStop()
        val onStops = PreferenceManager.getDefaultSharedPreferences(this).getInt("onStops", 0)
        if(onStops == 0){
            mediaplayer_music!!.pause()
        }
    }
}