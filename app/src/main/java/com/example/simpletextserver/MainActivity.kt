package com.example.simpletextserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.simpletextserver.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId){
                R.id.profileFragment -> {
                    replaceFragment(profileFragment())
                }
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                }
                R.id.registerFragment -> {
                   replaceFragment(RegisterFragment())
                }
                else->{
                   replaceFragment(HomeFragment())
                }
            }

            return@setOnItemSelectedListener false
        }


    }

    fun replaceFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

}