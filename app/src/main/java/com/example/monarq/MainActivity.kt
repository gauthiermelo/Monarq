package com.example.monarq

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.monarq.databinding.ActivityMainBinding
import com.example.monarq.ui.monarq.homepage.FamilyCreateActivity
import com.example.monarq.ui.monarq.homepage.FamilyJoinActivity

import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var providers : List<AuthUI.IdpConfig>
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    val MY_REQUEST_CODE=1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init
        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )

        showSignInOptions()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MY_REQUEST_CODE) {


            val model = ViewModelProvider(this)[MainViewModel::class.java]
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "" + response!!.error!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun showSignInOptions() {
        //startActivityForResult (we expect some result from this new activity)
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setIsSmartLockEnabled(false)
            .setAvailableProviders(providers)
            .setTheme(R.style.MyTheme)
            .build(), MY_REQUEST_CODE)
    }
}
