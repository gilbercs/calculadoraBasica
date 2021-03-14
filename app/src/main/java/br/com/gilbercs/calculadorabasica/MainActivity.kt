package br.com.gilbercs.calculadorabasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var textoResultado: TextView
    lateinit var valor1: EditText
    lateinit var valor2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentes()
        textoResultado.visibility = View.GONE
    }
    private fun inicializarComponentes() {
        valor1 = findViewById<EditText>(R.id.idValor1)
        valor2 = findViewById<EditText>(R.id.idValor2)
        textoResultado = findViewById<TextView>(R.id.idTextoResultado)
    }
    fun calculadora(calculo: View){
        val num1: Float
        val num2: Float
        val resultado: Float
        if (TextUtils.isEmpty(valor1.text.toString())){
            valor1.error = "Digite um numero valido!"
            return
        }else{
            num1 = valor1.text.toString().toFloat()
        }
        if (TextUtils.isEmpty(valor2.text.toString())){
            valor2.error = "Digite um numero valido!"
            return
        }else{
            num2 = valor2.text.toString().toFloat()
        }
        when (calculo.id){
            R.id.idBtnAdicao ->{
                resultado = num1 + num2
                limparCampos()
                textoResultado.visibility = View.VISIBLE
                textoResultado.text = ("$num1 + $num2 ="+resultado.toString())
            }
            R.id.idBtnSubtracao->{
                resultado = num1 - num2
               limparCampos()
                textoResultado.visibility = View.VISIBLE
                textoResultado.text = ("$num1 - $num2 ="+resultado.toString())
            }
            R.id.idBtnMultiplicacao->{
                resultado = num1 * num2
                limparCampos()
                textoResultado.visibility = View.VISIBLE
                textoResultado.text = ("$num1 * $num2 ="+resultado.toString())
            }
            R.id.idBtnDivisao->{
                resultado = num1 / num2
                limparCampos()
                textoResultado.visibility = View.VISIBLE
                textoResultado.text = ("$num1 / $num2 ="+resultado.toString())
            }
        }
    }
    private fun limparCampos() {
        valor1.setText("")
        valor2.setText("")
        valor1.requestFocus()
    }
}