package com.kevinrsebastian.androidex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()
    private var keepSplashScreenOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        // Returns a SplashScreen object which can be used to customize the animation or duration.
        installSplashScreen().apply {
            // Checks continuously and if the condition is true, keep showing splash screen.
            this.setKeepOnScreenCondition { keepSplashScreenOn }
            // Simulate waiting for a process to finish before dismissing the splash screen.
            fakeProcess(callBack = { keepSplashScreenOn = false })
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    /**
     * Simulate a running process by using a [Completable] with a delay. The passed callBack function will be
     * executed if the process completes or fails.
     * Delay is currently set to 3000ms.
     */
    private fun fakeProcess(callBack: () -> Unit) {
        Completable.complete()
            .delay(3000, TimeUnit.MILLISECONDS)
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }
                override fun onComplete() {
                    callBack()
                }
                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    callBack()
                }
            })
    }
}
