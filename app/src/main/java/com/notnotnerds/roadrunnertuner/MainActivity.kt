package com.notnotnerds.roadrunnertuner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.notnotnerds.roadrunnertuner.databinding.ActivityMainBinding
import com.notnotnerds.roadrunnertuner.databinding.FragmentHomeBinding
import com.notnotnerds.roadrunnertuner.ui.dashboard.DashboardFragment
import com.notnotnerds.roadrunnertuner.ui.home.HomeFragment
import com.notnotnerds.roadrunnertuner.ui.settings.Settings
import com.notnotnerds.roadrunnertuner.ui.tuners.TunerFragment
import com.notnotnerds.roadrunnertuner.ui.tuners.drive_setup.DriveEncoderAndDriveConstants

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var pressedTime: Long = 0
    lateinit var fragmentManager: FragmentManager
    var startButton: Boolean = false
    private lateinit var chub: DashboardFragment
/*** region setup */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        chub=DashboardFragment()
        binding.appBarMain.fab.setOnClickListener {
            Toast.makeText(baseContext, "notnotnerds@gmail.com is our email, if you would like to report a bug", Toast.LENGTH_LONG).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_dashboard, R.id.nav_drive_constants
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        fragmentManager=supportFragmentManager
        if(findViewById<View>(R.id.container) !=null){
            if(savedInstanceState != null){
                return
            }
            var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val tuningFragment: TunerFragment =  TunerFragment()
            fragmentTransaction.add(R.id.container, tuningFragment, null)
            fragmentTransaction.commit()

            if(!chub.chub){
                fragmentTransaction.detach(fragmentManager.findFragmentByTag("DashboardFragment")!!)
                fragmentTransaction.commit()
               Toast.makeText(this, "Unloaded fragment", Toast.LENGTH_SHORT).show()
                fragmentTransaction.attach(fragmentManager.findFragmentByTag("DashboardFragment")!!)
                fragmentTransaction.commit()
                Toast.makeText(this, "reloaded fragment", Toast.LENGTH_SHORT).show()
            }
        }



    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
/** region removal */
    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings were pressed", Toast.LENGTH_SHORT).show()
                fragmentManager.beginTransaction().replace(R.id.container, HomeFragment(), null).commit()
            }
            R.id.action_restart -> Toast.makeText(this,
                "Restarting App (in the future)",
                Toast.LENGTH_SHORT).show()
            R.id.action_chub -> {
                Toast.makeText(this, "Changing to robot controller phone", Toast.LENGTH_SHORT).show()
                val dialogBuilder = AlertDialog.Builder(this)
                    .setTitle("Select your RC device")
                    .setMessage("Select whether you have a control hub or android phone")
                    .setPositiveButton("Control Hub") { _, _-> }
                    .setNeutralButton("Android Phone") { _, _-> }
                dialogBuilder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @SuppressLint("ResourceType")
    fun startTuningProcess(view: android.view.View) {
        fragmentManager.beginTransaction().add(R.id.container, DriveEncoderAndDriveConstants()).commit()
        fragmentManager.beginTransaction().remove(HomeFragment()).commit()

        startButton=true
        Toast.makeText(this, "start tuning", Toast.LENGTH_SHORT).show()
/*
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)*/

    }
    /*fun showSettings(item: android.view.MenuItem) {setContentView(R.layout.app_bar_main)}
    fun onPreferenceStartFragment(caller: PreferenceFragmentCompat, pref: Preference): Boolean {
        // Instantiate the new Fragment
        val args = pref.extras
        val fragment = supportFragmentManager.fragmentFactory.instantiate(
            classLoader,
            pref.fragment)
        fragment.arguments = args
        fragment.setTargetFragment(caller, 0)
        // Replace the existing Fragment with the new Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.action_settings, fragment)
            .addToBackStack(null)
            .commit()
        return true
    }
*/
    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }

}