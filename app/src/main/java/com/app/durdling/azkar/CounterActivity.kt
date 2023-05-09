package com.app.durdling.azkar

import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.app.durdling.azkar.databinding.ActivityCounterBinding


class CounterActivity : AppCompatActivity() {

    companion object {
        const val ZEKER_POSITION = "zekerPostition"
    }

    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.azkarViewPager.apply {
            adapter = CounterViewPagerAdapter(this@CounterActivity)
            setCurrentItem(intent.getIntExtra(ZEKER_POSITION, 0), false)
        }
    }

    fun nextZeker() {
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            v.vibrate(500)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            binding.azkarViewPager.setCurrentItem(++binding.azkarViewPager.currentItem, true)
        }, 250)
    }


}