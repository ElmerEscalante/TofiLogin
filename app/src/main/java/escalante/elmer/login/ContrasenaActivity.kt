package escalante.elmer.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ContrasenaActivity : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevacontrasena)

        auth = Firebase.auth

        val et_correo: EditText = findViewById(R.id.et_correo_cont)
        val btn_restablecer: Button = findViewById(R.id.btnRestablecer)

        btn_restablecer.setOnClickListener{
            var correo: String = et_correo.text.toString().trim()

            //Validar campo vacio
            if(correo.isNullOrEmpty()){
                Toast.makeText(this, "Favor de llenar el correo", Toast.LENGTH_SHORT).show()
            }else{
                auth.sendPasswordResetEmail(correo).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Se ha enviado el correo", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "A ocurrido algun error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
