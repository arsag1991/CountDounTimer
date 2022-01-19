package com.example.countdountimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.countdountimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.apply {
        bStart.setOnClickListener {
            startCountDownTimer(20000)
        }
    }
    }
    private fun startCountDownTimer(timeMillies: Long){
        timer?.cancel()
        timer = object: CountDownTimer(timeMillies, 10 ){
            override fun onTick(timeM: Long) {
                binding.tvTimer.text = timeM.toString()
            }

            override fun onFinish() {
        binding.tvTimer.text = "Finish"
            }

        }.start()
    }


}