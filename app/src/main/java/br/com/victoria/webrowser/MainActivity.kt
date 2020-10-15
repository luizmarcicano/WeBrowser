package br.com.victoria.webrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Habilitar execução JS no WebView
        wbvSite.settings.javaScriptEnabled = true

        //URL padrão
        wbvSite.loadUrl("https://www.google.com/")

        //Cliente web padrão
        wbvSite.webViewClient = WebViewClient()

        // TODO Back button
        btnBack.setOnClickListener{
            if(wbvSite.canGoBack()){
                wbvSite.goBack()
            } else{
                Toast.makeText(this@MainActivity, "Não há para onde retornar", Toast.LENGTH_LONG).show()
            }
        }

        //TODO Next button
        btnNext.setOnClickListener{
            if(wbvSite.canGoForward()){
                wbvSite.goForward()
            } else{
                Toast.makeText(this@MainActivity, "Não há para onde avançar", Toast.LENGTH_LONG).show()
            }
        }

        //TODO Refresh button
        btnRefresh.setOnClickListener{
            wbvSite.reload()
        }

        //TODO Search
        var migue = true;
        btnSearch.setOnClickListener{
            var migue = false;
            var aux = txtUrl.text.toString().split(" ")
            var a = SpannableStringBuilder(aux.joinToString(separator="+"))
            txtUrl.text = a
            wbvSite.loadUrl("https://www.google.com/search?q=" + txtUrl.text.toString())
        }




        txtUrl.setText(wbvSite.url)

        txtUrl.setOnClickListener{
            wbvSite.requestFocus()
            if(wbvSite.hasFocus()){
                if(txtUrl.text.toString().substring(0,4).equals("http")){
                    wbvSite.loadUrl(txtUrl.text.toString())
                } else if(!txtUrl.text.toString().substring(0,4).equals("http") && migue ==false){
                    migue = true;
                } else {
                    wbvSite.loadUrl("http://" + txtUrl.text.toString())
                }
            }
        }

    }
}