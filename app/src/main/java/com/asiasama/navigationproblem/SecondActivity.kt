package com.asiasama.navigationproblem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.asiasama.navigationproblem.MainActivity.Companion.subject
import com.asiasama.navigationproblem.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribDownload()

    }

    @SuppressLint("CheckResult")
    private fun subscribDownload() {
        subject.subscribe(
            {
                runOnUiThread {
                    binding.textView.text = it.toString()
                    binding.progressBar.progress = it.toInt()
                    Log.e("TAG", "screen2: $it")
                    if (it.toInt() == 10) {
                        binding.textView.text = "Download successfully"
                    }
                }
            },
            {
                Log.e("TAG", "screen2 with error: $it")
            },
            {
                Log.e("TAG", "screen2 complet:")
            }
        )
    }

    @SuppressLint("CheckResult")
    fun navigateToFirstActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }


}