package com.jkt.githubrepoapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jkt.githubrepoapplication.ui.GitProjectListActivtiy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mGo: Button
    lateinit var musersId: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initUI()
        mGo.setOnClickListener {

            if (musersId.length() > 0) {
                moveToListActivtiy(musersId.text.toString())
            } else {
                Toast.makeText(this, "UserId cant be blank", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun initUI() {
        mGo = findViewById<Button>(R.id.go)
        musersId = findViewById(R.id.userId)
    }


    private fun moveToListActivtiy(muserid: String) {
        val intent = Intent(this@MainActivity, GitProjectListActivtiy::class.java)
        intent.putExtra("Username", muserid)
        startActivity(intent)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
