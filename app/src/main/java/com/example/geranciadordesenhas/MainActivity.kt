package com.example.geranciadordesenhas

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

const val MOCK_SENHA = "123456"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoEntrar = entrarButton
        val dialogBuilder = AlertDialog.Builder(this)

        botaoEntrar.setOnClickListener {
            val senhaDigitada: String = senhaHome.text.toString()
            if (senhaDigitada == MOCK_SENHA) {
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            } else {
                dialogBuilder.setMessage("Senha incorreta")
                    .setCancelable(false)
                    .setPositiveButton("OK", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()})
                val alert = dialogBuilder.create()
                alert.setTitle("Aviso")
                alert.show()
            }
        }

    }
}