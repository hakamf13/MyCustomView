package com.dicoding.advanceui.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.dicoding.advanceui.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myButton = binding.myButton
        myEditText = binding.editText

        setMyButtonEnabled()

        myEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        myButton.setOnClickListener {
            Toast.makeText(this@MainActivity, myEditText.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setMyButtonEnabled() {
        val result = myEditText.text
        myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}