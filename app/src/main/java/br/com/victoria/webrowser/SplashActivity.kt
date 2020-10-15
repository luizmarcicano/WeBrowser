package br.com.victoria.webrowser

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ //funcao lambida como parametro do postDelayed

            //Criando a Intent
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))

        },5000)
    }
}
