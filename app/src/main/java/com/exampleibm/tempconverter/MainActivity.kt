package com.exampleibm.tempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Button
import com.exampleibm.tempconverter.databinding.ActivityMainBinding


//model class
class Converter{
    companion object{
        fun c2f(c: Double) = (9.0/5.0)*c + 32
        fun f2c(f: Double) = (5.0/9.0)*(f - 32)
    }
}// controller class
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // wire up my controls
//        val temperature: EditText = findViewById(R.id.temperature)
//        val c2f: RadioButton = findViewById(R.id.c2f)
//        val convertButton: Button = findViewById(R.id.convert_button)
        
        binding.convertButton.setOnClickListener {

                var t = binding.temperature.text.toString().toDoubleOrNull()
                if(t != null){
                    t = if(binding.c2f.isChecked){
                        Converter.c2f(t)
                    }else{
                        Converter.f2c(t)
                    }
                   binding.temperature.setText(t.toString())
                }else{
                    binding.temperature.setText("Invalid Input")
                }
            }

        }

}
