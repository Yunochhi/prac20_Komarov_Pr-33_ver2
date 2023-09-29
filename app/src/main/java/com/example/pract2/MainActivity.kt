package com.example.pract2
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var standart : Button
    lateinit var call : Button
    lateinit var cumstom : Button
    lateinit var floating_btn: FloatingActionButton
    lateinit var settings:SharedPreferences
    lateinit var count:TextView

    public final var APP_PREFERENCES = "mysetting"
    public var PREFS_COUNT = "Count"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        standart = findViewById(R.id.stndr)
        call = findViewById(R.id.cstm)
        cumstom = findViewById(R.id.nstndr)
        floating_btn = findViewById(R.id.fab)
        count = findViewById(R.id.count)

        settings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)


        standart.setOnClickListener{
            val snack3 = Snackbar.make(it,"Самый обычный Snackbar",Snackbar.LENGTH_LONG)
            snack3.show()
        }

        call.setOnClickListener{
            val snack = Snackbar.make(it,"Вы изменили что-то",Snackbar.LENGTH_LONG)
            snack.setAction("Вернуть как было?", View.OnClickListener
            {
                val snack1 = Snackbar.make(it,"Все вернулось на свои места",Snackbar.LENGTH_LONG)
                snack1.show()
            })
            snack.show()
        }

        cumstom.setOnClickListener{

            val snack = Snackbar.make(it,"Повторите еще раз",Snackbar.LENGTH_LONG)
            snack.setActionTextColor(Color.YELLOW)
            snack.setBackgroundTint(Color.MAGENTA)
            snack.setTextColor(Color.YELLOW);
            snack.setAction("Повторить", View.OnClickListener
            {
                val snack1 = Snackbar.make(it,"Все вернулось на свои места",Snackbar.LENGTH_LONG)
                snack1.show()
            })
            snack.show()
        }

        var press_count = settings.getInt(PREFS_COUNT,0)
        floating_btn.setOnClickListener{
            val snack = Snackbar.make(it,"Вы нажали на FloatingActionButton",Snackbar.LENGTH_SHORT)
            snack.show()

            var prefEditor = settings.edit()
            press_count += 1
            count.text = press_count.toString()

            prefEditor.putInt(PREFS_COUNT, press_count)
            prefEditor.apply()

        }
    }
}