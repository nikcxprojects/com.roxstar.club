package com.roxstar.club

import android.animation.ObjectAnimator
import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.roxstar.club.imageViewScrolling1.IEventEnd1
import com.roxstar.club.imageViewScrolling1_0.IEventEnd1_0
import com.roxstar.club.imageViewScrolling1_1.IEventEnd1_1
import com.roxstar.club.imageViewScrolling1_2.IEventEnd1_2
import com.roxstar.club.imageViewScrolling1_3.IEventEnd1_3
import com.roxstar.club.imageViewScrolling1_4.IEventEnd1_4
import kotlinx.android.synthetic.main.activity_slot_games1.*
import kotlin.random.Random

class SlotGamesActivity1 : AppCompatActivity(),IEventEnd1, IEventEnd1_0, IEventEnd1_1, IEventEnd1_2, IEventEnd1_3, IEventEnd1_4 {
    internal  var count_down = 0

    var bet = 100
    var argument:Int? = null

    var timer = 0

    var lines = 5

    var credit = 10000

    var start_button = 0

    var risk_button = 0

    var index_credit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot_games1)


        hideSystemBars()

        textView7.text = credit.toString()

        slots1.setEventEnd(this@SlotGamesActivity1)
        slots2.setEventEnd(this@SlotGamesActivity1)
        slots3.setEventEnd(this@SlotGamesActivity1)
        slots4.setEventEnd(this@SlotGamesActivity1)
        slots5.setEventEnd(this@SlotGamesActivity1)

        slots6.setEventEnd(this@SlotGamesActivity1)
        slots7.setEventEnd(this@SlotGamesActivity1)
        slots8.setEventEnd(this@SlotGamesActivity1)
        slots9.setEventEnd(this@SlotGamesActivity1)
        slots10.setEventEnd(this@SlotGamesActivity1)

        slots11.setEventEnd(this@SlotGamesActivity1)
        slots12.setEventEnd(this@SlotGamesActivity1)
        slots13.setEventEnd(this@SlotGamesActivity1)
        slots14.setEventEnd(this@SlotGamesActivity1)
        slots15.setEventEnd(this@SlotGamesActivity1)

        imageView13.setOnClickListener {
            if(start_button == 0){
                vibratePhone()
                val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
                if(volume == 1){
                    Music.mediaplayer_sounds!!.start()
                }
                start_button = 1
                risk_button = 0
                if(credit >= bet){
                    credit -= bet
                    textView7.text = credit.toString()
                    slots1.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots2.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots3.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)

                    slots4.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots5.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots6.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)

                    slots7.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots8.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots9.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)

                    slots10.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots11.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots12.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)

                    slots13.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots14.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                    slots15.setValueRandom(
                        Random.nextInt(8),
                        Random.nextInt(10-5+1)+4)
                }else{
                    vibratePhone()
                    Toast.makeText(this,"No Balance",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun anim(view: View){
        val objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0f,360f)
        objectAnimator.duration = 1000
        objectAnimator.start()
    }

    override fun eventEnd(result: Int, count: Int) {
        if(count_down < 14){
            count_down++
//            Log.d("valss", "hnsadhjnhjsand \n$count_down")
        }
        else{
            timer = 1
            count_down = 0
            argument = 0
            val slot1 =slots1.value_
            val slot2 =slots2.value_
            val slot3 =slots3.value_
            val slot4 =slots4.value_
            val slot5 =slots5.value_

            Log.d("valss","sadsd\n${slot1}")
            Log.d("valss","sadsd\n$slot2")
            Log.d("valss","sadsd\n$slot3")
            Log.d("valss","sadsd\n$slot4")
            Log.d("valss","sadsd\n$slot5")

            val slot6 =slots6.value_
            val slot7 =slots7.value_
            val slot8 =slots8.value_
            val slot9 =slots9.value_
            val slot10 =slots10.value_

            Log.d("valss","sadsd\n${slot6}")
            Log.d("valss","sadsd\n$slot7")
            Log.d("valss","sadsd\n$slot8")
            Log.d("valss","sadsd\n$slot9")
            Log.d("valss","sadsd\n$slot10")

            val slot11 =slots11.value_
            val slot12 =slots12.value_
            val slot13 =slots13.value_
            val slot14 =slots14.value_
            val slot15 =slots15.value_

            Log.d("valss","sadsd\n${slot11}")
            Log.d("valss","sadsd\n$slot12")
            Log.d("valss","sadsd\n$slot13")
            Log.d("valss","sadsd\n$slot14")
            Log.d("valss","sadsd\n$slot15")

            Handler(Looper.myLooper()!!).postDelayed(
                {
                   if(lines == 5){
                        if(slot1 == slot4 && slot4 == slot7 && slot7 == slot10 && slot10 == slot13){
                            Symbols(slot1,3)
                            anim(slots1)
                            anim(slots4)
                            anim(slots7)
                            anim(slots10)
                            anim(slots13)
                        }
                        else if(slot1 == slot4 && slot4 == slot7 && slot7 == slot10){
                            Symbols(slot1,2)
                            anim(slots1)
                            anim(slots4)
                            anim(slots7)
                            anim(slots10)
                        }
                        else if(slot1 == slot4 && slot4 == slot7){
                            Symbols(slot1,1)
                            anim(slots1)
                            anim(slots4)
                            anim(slots7)
                        }
                        if(slot2 == slot5 && slot5== slot8 && slot8 == slot11 && slot11 == slot14){
                            Symbols(slot2,3)
                            anim(slots2)
                            anim(slots5)
                            anim(slots8)
                            anim(slots11)
                            anim(slots14)
                        }
                        else if(slot2 == slot5 && slot5 == slot8 && slot8 == slot11){
                            Symbols(slot2,2)
                            anim(slots2)
                            anim(slots5)
                            anim(slots8)
                            anim(slots11)
                        }
                        else if(slot2 == slot5 && slot5 == slot8){
                            Symbols(slot2,1)
                            anim(slots2)
                            anim(slots5)
                            anim(slots8)
                        }
                        if(slot3 == slot6 && slot6== slot9 && slot9 == slot12 && slot12 == slot15){
                            Symbols(slot3,3)
                            anim(slots3)
                            anim(slots6)
                            anim(slots9)
                            anim(slots12)
                            anim(slots15)
                        }
                        else if(slot3 == slot6 && slot6 == slot9 && slot9 == slot12){
                            Symbols(slot3,2)
                            anim(slots3)
                            anim(slots6)
                            anim(slots9)
                            anim(slots12)
                        }
                        else if(slot3 == slot6 && slot6 == slot9){
                            Symbols(slot3,1)
                            anim(slots3)
                            anim(slots6)
                            anim(slots9)
                        }
                        if(slot1 == slot5 && slot5 == slot9 && slot9 == slot11 && slot11 == slot13){
                            Symbols(slot1,3)
                            anim(slots1)
                            anim(slots5)
                            anim(slots9)
                            anim(slots11)
                            anim(slots13)
                        }
                        else if(slot1 == slot5 && slot5 == slot9 && slot9 == slot11){
                            Symbols(slot1,2)
                            anim(slots1)
                            anim(slots5)
                            anim(slots9)
                            anim(slots11)
                        }
                        else if(slot1 == slot5 && slot5 == slot9){
                            Symbols(slot1,1)
                            anim(slots1)
                            anim(slots5)
                            anim(slots9)
                        }
                        if(slot3 == slot5 && slot5 == slot7 && slot7 == slot11 && slot11 == slot15){
                            Symbols(slot1,3)
                            anim(slots3)
                            anim(slots5)
                            anim(slots7)
                            anim(slots11)
                            anim(slots15)
                        }
                        else if(slot3 == slot5 && slot5 == slot7 && slot7 == slot11){
                            Symbols(slot3,2)
                            anim(slots3)
                            anim(slots5)
                            anim(slots7)
                            anim(slots11)
                        }
                        else if(slot3 == slot5 && slot5 == slot7){
                            Symbols(slot3,1)
                            anim(slots3)
                            anim(slots5)
                            anim(slots7)
                        }
                    }
                    start_button = 0
                }, 1500
            )
        }
    }

    fun Symbols(index :Int,win :Int){
        if(lines == 5){
            imageView18.visibility = View.VISIBLE
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    imageView18.visibility = View.GONE
                },1000)
        }
        if(index == 0){
            Symbols1(win)
        }else if(index == 1){
            Symbols2(win)
        }else if(index == 2){
            Symbols3(win)
        }else if(index == 3){
            Symbols4(win)
        }else if(index == 4){
            Symbols5(win)
        }else if(index == 5){
            Symbols6(win)
        }else if(index == 6){
            Symbols7(win)
        }else if(index == 7){
            Symbols8(win)
        }
        risk_button = 1
        val volume = PreferenceManager.getDefaultSharedPreferences(this).getInt("volume", 1)
        if(volume == 1){
            Music.mediaplayer_sounds!!.start()
        }
    }

    fun Symbols1 (win :Int){
        if(win == 3){
            //*40
            Toast.makeText(this,"${bet*40}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*40)
            index_credit = 40
        }else if(win == 2){
            //*30
            Toast.makeText(this,"${bet*30}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*30)
            index_credit = 30
        }else if(win == 1){
            //*20
            Toast.makeText(this,"${bet*20}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*20)
            index_credit = 20
        }
    }

    fun Symbols2 (win :Int){
        if(win == 3){
            //*70
            Toast.makeText(this,"${bet*70}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*70)
            index_credit = 70
        }else if(win == 2){
            //*60
            Toast.makeText(this,"${bet*60}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*60)
            index_credit = 60
        }else if(win == 1){
            //50
            Toast.makeText(this,"${bet*50}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*50)
            index_credit = 50
        }
    }

    fun Symbols3 (win :Int){
        if(win == 3){
            //*100
            Toast.makeText(this,"${bet*100}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*100)
            index_credit = 100
        }else if(win == 2){
            //*85
            Toast.makeText(this,"${bet*85}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*85)
            index_credit = 85
        }else if(win == 1){
            //*70
            Toast.makeText(this,"${bet*70}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*70)
            index_credit = 70
        }
    }

    fun Symbols4 (win :Int){
        if(win == 3){
            //*20
            Toast.makeText(this,"${bet*20}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*20)
            index_credit = 20
        }else if(win == 2){
            //*15
            Toast.makeText(this,"${bet*15}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*15)
            index_credit = 15
        }else if(win == 1){
            //*10
            Toast.makeText(this,"${bet*10}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*10)
            index_credit = 10
        }
    }

    fun Symbols5 (win :Int){
        if(win == 3){
            //*10
            Toast.makeText(this,"${bet*10}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*10)
            index_credit = 10
        }else if(win == 2){
            //*5
            Toast.makeText(this,"${bet*5}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*5)
            index_credit = 5
        }else if(win == 1){
            //*4
            Toast.makeText(this,"${bet*4}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*4)
            index_credit = 4
        }
    }

    fun Symbols6 (win :Int){
        if(win == 3){
            //*15
            Toast.makeText(this,"${bet*15}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*15)
            index_credit = 15
        }else if(win == 2){
            //*10
            Toast.makeText(this,"${bet*10}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*10)
            index_credit = 10
        }else if(win == 1){
            //*5
            Toast.makeText(this,"${bet*5}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*5)
            index_credit = 5
        }
    }

    fun Symbols7 (win :Int){
        if(win == 3){
            //*4
            Toast.makeText(this,"${bet*4}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*4)
            index_credit = 4
        }else if(win == 2){
            //*3
            Toast.makeText(this,"${bet*3}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*3)
            index_credit = 3
        }else if(win == 1){
            //*2
            Toast.makeText(this,"${bet*2}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*2)
            index_credit = 2
        }
    }

    fun Symbols8 (win :Int){
        if(win == 3){
            //*5
            Toast.makeText(this,"${bet*5}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*5)
            index_credit = 5
        }else if(win == 2){
            //*4
            Toast.makeText(this,"${bet*4}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*4)
            index_credit = 4
        }else if(win == 1){
            //*3
            Toast.makeText(this,"${bet*3}",Toast.LENGTH_SHORT).show()
            credit = credit + (bet*3)
            index_credit = 3
        }

    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

    override fun onResume() {
        super.onResume()

        val musics = PreferenceManager.getDefaultSharedPreferences(this).getInt("music", 1)
        if(musics == 1){
            Music.mediaplayer_music!!.start()
            Music.mediaplayer_music!!.isLooping = true
        }else{

        }

        Handler(Looper.myLooper()!!).postDelayed(
            {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("onStops", 0).apply()
            },1000)
    }

    fun vibratePhone() {
        val vibration = PreferenceManager.getDefaultSharedPreferences(this).getInt("vibration", 1)
        if(vibration == 1){
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(200)
            }
        }
    }
}