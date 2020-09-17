package ru.fidean.testtask

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        var navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        var pref =
            getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        reload.setOnClickListener {
            pref.edit().remove(getString(R.string.boolean_key)).apply()
            navController.navigate(R.id.check)
        }
    }


}