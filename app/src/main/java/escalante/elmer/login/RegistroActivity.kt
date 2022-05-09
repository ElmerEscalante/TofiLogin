package escalante.elmer.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)


        val et_usuario: EditText = findViewById(R.id.Usuario)
        val et_correo: EditText = findViewById(R.id.correoElectronico)
        val et_contra1: EditText = findViewById(R.id.password)
        val et_contra2: EditText = findViewById(R.id.repitPassword)
        val btn_registrar: Button = findViewById(R.id.btnRegistro)

        btn_registrar.setOnClickListener{
            var usuario: String = et_usuario.text.toString().trim()
            var correo: String = et_correo.text.toString().trim()
            var contra1: String = et_contra1.text.toString().trim()
            var contra2: String = et_contra2.text.toString().trim()

            if(usuario.isNullOrEmpty() || correo.isNullOrEmpty() || contra1.isNullOrEmpty() || contra2.isNullOrEmpty()){
                Toast.makeText(this, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                if(contra1 != contra2){
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }else{

                }
            }

        }
    }
}
