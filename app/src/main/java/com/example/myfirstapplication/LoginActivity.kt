package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var dataEmail : Array<String>
    private lateinit var dataPassword : Array<String>
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail : EditText = findViewById(R.id.edit_email)
        val edtPassword : EditText = findViewById(R.id.edit_password)
        val btnLogin : Button = findViewById(R.id.btn_login)
        val btnRegister : Button = findViewById(R.id.btn_register)
        progressBar = findViewById(R.id.progress_bar)
        val btnForgetPass : TextView = findViewById(R.id.forget_password)
        val radioRemember : RadioButton = findViewById(R.id.rememberme)

//        val builder = AlertDialog.Builder(this, R.style.AlertDialog_AppCompat).create()
//        builder.setTitle("Harap isi")
//        builder.setMessage("Tentukan pilihan anda!")
//        builder.setIcon(R.drawable.ic_person)
//        builder.setCancelable(true)
//        builder.show()

        dataEmail = arrayOf("Mochammad", "Faiz", "Adli")
        dataPassword = arrayOf("1234", "4321", "1423")

        btnLogin.setOnClickListener {
            progressBar?.visibility = View.VISIBLE
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    fun signIn(email: String, password: String)
    {
        for (i in dataEmail.indices){
            val takeDataEmail = dataEmail.get(i)
            val takeDataPass = dataPassword.get(i)
            if (takeDataEmail == email && takeDataPass == password){
                Toast.makeText(this, "LogedIn", Toast.LENGTH_SHORT).show()
                progressBar?.visibility = View.GONE
                startActivity(Intent(this, HomeActivity::class.java))
                break
            }else{
                progressBar?.visibility = View.GONE
                Toast.makeText(this, "Akun Slaha", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
//onStart selalu muncul di awal aktifitas
//onCreate selalu terbentuk setiap memanggil aktivitas
//onPause selalu terpanggil untuk memeriksa ada/tidaknya kondisi dirinya ketika aktivitas berganti
//onResume selalu terpanggil untuk memeriksa ada/tidaknya kondisi onPause
//onStop hadir ketika onPause tidak diberi kondisi
//onRestart hadir ketika onResume tidak diberi kondisi
//onDestroy terpanggil ketika kill task/activity