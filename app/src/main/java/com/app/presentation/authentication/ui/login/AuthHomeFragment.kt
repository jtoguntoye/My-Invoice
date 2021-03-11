package com.app.presentation.authentication.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.myinvoice.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class AuthHomeFragment: Fragment(R.layout.auth_home_fragment) {

    companion object{
        const val RC_SIGN_IN = 123
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set up auth providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        FirebaseApp.initializeApp(requireContext());
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            var response = IdpResponse.fromResultIntent(data)
            if(resultCode == Activity.RESULT_OK) {
                val user =  FirebaseAuth.getInstance().currentUser
                //TODO navigate to the mainActivity
               // Log.d("TAG", user.tenantId)
            }
            else{

                if( response == null){
                    //remain in the authhomeFragment
                }
                if(response?.error?.errorCode ==ErrorCodes.NO_NETWORK){
                    //show no internet dialog

                }
            }

        }
    }
}