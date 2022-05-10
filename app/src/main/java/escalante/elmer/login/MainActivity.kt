package escalante.elmer.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        auth = Firebase.auth

        val Usuario: EditText = findViewById(R.id.Usuario)
        val Password: EditText = findViewById(R.id.password)
        val btnIniciarSesion: Button = findViewById(R.id.btnIniciarSesion)
        val btnRegistrar: Button = findViewById(R.id.btnRegistrar)
        val tv_olvidar: TextView = findViewById(R.id.tv_olvidar)

        btnRegistrar.setOnClickListener{
            startActivity(Intent(this, RegistroActivity::class.java))
        }
        tv_olvidar.setOnClickListener{
            startActivity(Intent(this, ContrasenaActivity::class.java))
        }
        btnIniciarSesion.setOnClickListener{
            var correo: String = Usuario.text.toString().trim()
            var contra: String = Password.text.toString().trim()

            if(correo.isNullOrEmpty() || contra.isNullOrEmpty()){
                Toast.makeText(this, "Favor de llenar los campos", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(correo, contra)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(Intent(this, MainActivity::class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("login", "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }
                    }
            }
        }

    }
}