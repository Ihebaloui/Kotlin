package com.example.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next: Button = findViewById(R.id.next)
        val reset: Button = findViewById(R.id.reset)
        val homme: RadioButton = findViewById(R.id.rhomme)
        val femmme: RadioButton = findViewById(R.id.rfemme)
        homme.isChecked=true
        var test = false
        var nbAnd = 0
        var nbIos = 0
        var nbFlut = 0
        val android: SeekBar = findViewById<SeekBar>(R.id.sandroid)
        val ios: SeekBar = findViewById<SeekBar>(R.id.sios)
        val flutter: SeekBar = findViewById<SeekBar>(R.id.sflutter)
        next.setOnClickListener{
            test = checkAll()
            android?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar,
                                               progress: Int, fromUser: Boolean) {

                }
                override fun onStartTrackingTouch(seek: SeekBar) {
                }

                override fun onStopTrackingTouch(seek: SeekBar) {
                    nbAnd = seek.progress
                }
            })
            /* IOS */
            ios?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar,
                                               progress: Int, fromUser: Boolean) {

                }
                override fun onStartTrackingTouch(seek: SeekBar) {
                }

                override fun onStopTrackingTouch(seek: SeekBar) {
                    nbIos = seek.progress
                }
            })
            /* FLUTTER */
            flutter?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar,
                                               progress: Int, fromUser: Boolean) {
                    nbFlut = progress
                }
                override fun onStartTrackingTouch(seek: SeekBar) {
                }

                override fun onStopTrackingTouch(seek: SeekBar) {
                    nbFlut = seek.progress
                }
            })
            if( (nbAnd <=30) && (nbIos <=30) && (nbFlut <= 30) )
            {
                Toast.makeText(applicationContext, "Vous devez travailler vos skills",
                    Toast.LENGTH_SHORT).show()
            }
            if((nbAnd >30) && (nbIos > 30) && (nbFlut > 30))
            {
                Toast.makeText(applicationContext, "Vous avez de bons skills !",
                    Toast.LENGTH_SHORT).show()
            }
            if( (nbAnd>80) && (nbAnd>nbIos) && (nbAnd>nbFlut) )
            {
                Toast.makeText(applicationContext, "Vous êtes excellent en Android",
                    Toast.LENGTH_SHORT).show()
            }
            if((nbIos>80) && (nbIos>nbAnd) && (nbIos>nbFlut))
            {
                Toast.makeText(applicationContext, "Vous êtes excellent en Ios",
                    Toast.LENGTH_SHORT).show()
            }
            if((nbFlut>80) && (nbFlut>nbAnd) && (nbFlut>nbIos))
            {
                Toast.makeText(applicationContext, "Vous êtes excellent en Flutter",
                    Toast.LENGTH_SHORT).show()
            }
        }

        reset.setOnClickListener{
             nbAnd = 0
             nbIos = 0
            nbFlut = 0
            resetText()
        }



    }
    private fun resetText(): Boolean
    {
        val fullname: EditText = findViewById(R.id.tfullname)
        val age: EditText = findViewById(R.id.tage)
        val email: EditText = findViewById(R.id.temail)
        val homme: RadioButton = findViewById(R.id.rhomme)
        fullname.text.clear()
        age.text.clear()
        email.text.clear()
        val android: SeekBar = findViewById<SeekBar>(R.id.sandroid)
        val ios: SeekBar = findViewById<SeekBar>(R.id.sios)
        val flutter: SeekBar = findViewById<SeekBar>(R.id.sflutter)
        android.setProgress(0)
        ios.setProgress(0)
        flutter.setProgress(0)
        homme.isChecked=true
        return true
    }
    private fun Choice(): Boolean
    {



        return true
    }
 private fun checkAll(): Boolean {
     val fullname: EditText = findViewById(R.id.tfullname)
     val age: EditText = findViewById(R.id.tage)
     val email: EditText = findViewById(R.id.temail)
     var sFullname = fullname.getText().toString();
     var sage = age.getText().toString();
     var semail = email.getText().toString().trim();
     val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
     if(sFullname.isEmpty()&&sage.isEmpty()&&semail.isEmpty())
     {
         Toast.makeText(applicationContext, "Check your Input",
             Toast.LENGTH_SHORT).show()
         return false
     }
    if(sFullname.isEmpty())
    {
        Toast.makeText(applicationContext, "Check your Fullname",
            Toast.LENGTH_SHORT).show()
        return false
    }
     if(sage.isEmpty())
     {
         Toast.makeText(applicationContext, "Check your Age",
             Toast.LENGTH_SHORT).show()
         return false
     }
     if (semail.matches(emailPattern.toRegex())) {
     } else {
         Toast.makeText(applicationContext, "Check your Email",
             Toast.LENGTH_SHORT).show()
         return false
     }
     return true
 }
    fun onStopTrackingTouch(seek: SeekBar) {
        // write custom code for progress is stopped
        Toast.makeText(this@MainActivity,
            "Progress is: " + seek.progress + "%",
            Toast.LENGTH_SHORT).show()
    }
}