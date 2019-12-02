package com.example.httpvolley.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.httpvolley.R
import kotlinx.android.synthetic.main.activity_param_dialog.*
import kotlinx.android.synthetic.main.alert_dialog.view.*

class ParamDialogActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val lenguages = arrayOf("Ingle", "Español","Italiano", "Frances", "Russo", "Chino")
    var spinner:Spinner? = null
    val textView_msg:TextView?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param_dialog)

        val etInfo = findViewById<EditText>(R.id.eTInfo)
        val selector = findViewById<Spinner>(R.id.spinner_simple1)



        //spinner option 1-----------------------------
        val aa = ArrayAdapter(this, android.R.layout.simple_list_item_1, lenguages)
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1)

        with(spinner_simple)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@ParamDialogActivity
            prompt = "Select your favourite language"
            gravity = Gravity.CENTER

        }

       //Spinner option 2----------------------------
        val adt = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, lenguages)
        selector.adapter=adt
        selector.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@ParamDialogActivity, lenguages[position], Toast.LENGTH_SHORT).show()
            }

        }


        btnAlert.setOnClickListener{
            val mDialog = LayoutInflater.from(this).inflate(R.layout.alert_dialog, null)
            val alerDialog = AlertDialog.Builder(this)
            alerDialog.setTitle("Alert")
            alerDialog.setView(mDialog)

            val alert = alerDialog.show()
            mDialog.btLogin.setOnClickListener{
                alert.dismiss()

                val nombre = mDialog.EtNombre.text.toString()
                val correo = mDialog.EtCorreo.text.toString()
                val contrasenia = mDialog.eTContrasenia.text.toString()

                etInfo.setText("Nombre: "+ nombre +"\nCorreo: "+ correo +"\nContraseña: "+contrasenia)
            }
            mDialog.btnCancelar.setOnClickListener {
                alert.dismiss()
            }
        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        msg.text = lenguages[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}
