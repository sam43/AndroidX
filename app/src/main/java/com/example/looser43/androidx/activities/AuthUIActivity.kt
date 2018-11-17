package com.example.looser43.androidx.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.looser43.androidx.utils.debug
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class AuthUIActivity : AppCompatActivity() {

    // Choose authentication providers
    private val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
            // AuthUI.IdpConfig.FacebookBuilder().build(),
            //AuthUI.IdpConfig.TwitterBuilder().build()
    )

    companion object {
        private const val RC_SIGN_IN = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_auth_ui)
        buildAuthUI()
    }

    private fun buildAuthUI() {
        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            debug("response :: isNew : ${response?.isNewUser} phnNo: ${response?.phoneNumber} token : ${response?.idpToken}")

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                debug("user : ${user?.displayName} and email: ${user?.email}")
                startActivity(Intent(this, BottomAppBarActivity::class.java))
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}
