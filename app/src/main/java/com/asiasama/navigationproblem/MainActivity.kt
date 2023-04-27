package com.asiasama.navigationproblem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.asiasama.navigationproblem.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickDownload()
        navigateToSecondActivity()
        Log.e("TAG", "onCreate: ")
    }

    @SuppressLint("CheckResult")
    private fun onClickDownload() {
        binding.downloadButton.setOnClickListener {
            Observable
                .interval(1, TimeUnit.SECONDS).take(11)
                .subscribeOn(Schedulers.io())
                .subscribe(subject)
            Toast.makeText(this, "Start Download ", Toast.LENGTH_SHORT).show()        }
    }

    private fun navigateToSecondActivity() {
        binding.goToSecondScreenButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {
        val subject: PublishSubject<Long> = PublishSubject.create()
    }


}


