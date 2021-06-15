package aldana.jesus.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val btnCalcular: Button = findViewById(R.id.calcular)
        val imc: TextView = findViewById(R.id.imc)
        val range: TextView = findViewById(R.id.range)

        var color: String

        fun calcularIMC(): Float{
            val w = weight.text.toString().toFloat()
            val h = height.text.toString().toFloat()
            val h2 = h*h
            return (w/h2)
        }

        fun calcularRango(): String{
            val imcR = calcularIMC()
            if (imcR < 18.5){
                return ("Bajo Peso")
            }
            if (imcR >= 18.5 || imcR <= 24.9){
                return("Normal")
            }
            if (imcR >= 25 || imcR <= 29.9){
                return("Sobrepeso")
            }
            if (imcR >= 30 || imcR <= 34.9){
                return("Obesidad grado 1")
            }
            if (imcR >= 35 || imcR <= 39.9){
                return("Obesidad grado 2")
            }
            if (imcR >= 40){
                return("Obesidad grado 3")
            }
            return ("")
        }

        btnCalcular.setOnClickListener{
            imc.text = (calcularIMC().toString())
            range.text = (calcularRango())
        }

    }
}