package com.example.simpletextserver

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.splash_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView , HomeFragment())
                .commit()
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
        hideBottomNavigation()
    }

    override fun onStop() {
        super.onStop()
        showBottomNavigation()
    }


    fun showBottomNavigation(){
        val bottomNavigation = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        bottomNavigation?.visibility = View.VISIBLE
    }

    fun hideBottomNavigation(){
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        bottomNavigationView?.visibility = View.GONE
    }


}