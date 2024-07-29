package com.vanka.swipeyc21.utils

import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.databinding.BottomSheetBinding

class BottomAuthSheet:BottomSheetDialogFragment() {
    private lateinit var oneTapClient: SignInClient
    private lateinit var signUpRequest: BeginSignInRequest
    // Activity result launcher for handling One Tap sign-in result
    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        Toast.makeText(requireContext(), "Sucess", Toast.LENGTH_SHORT).show()

        try {
            // Initialize SharedPreferencesManager for managing login state
            //val sharedPreferencesManager = SharedPreferencesManager(requireContext())
            // Retrieve Google credential from the sign-in result
            val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
            val idToken = credential.googleIdToken
            if (idToken != null) {
                Toast.makeText(requireContext(), "yess", Toast.LENGTH_SHORT).show()
                // Successfully retrieved Google ID token, user is considered logged in
                //sharedPreferencesManager.isLoggedIn = true

                // Navigate to the HomeFragment upon successful login
//                requireActivity().supportFragmentManager.beginTransaction()
//                    .add(R.id.fragment_container, HomeFragment())
//                    .commit()

            }
        } catch (e: ApiException) {
            when (e.statusCode) {
                CommonStatusCodes.CANCELED -> {
                    Log.d("OneTap", "One-tap dialog was closed.")
                }
                CommonStatusCodes.NETWORK_ERROR -> {
                    Log.d("OneTap", "One-tap encountered a network error.")
                }
                else -> {
                    Log.d("OneTap", "Couldn't get credential from result. (${e.localizedMessage})")
                }
            }
        }
    }

    private var _binding: BottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }
//854416629727-nt15tpq9tk7pt3kg4n3l14d06v19rut7.apps.googleusercontent.com
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.textView.text = "Hello from Bottom Sheet"
//        binding.button.setOnClickListener {
//            dismiss()
//        }
    val serverClientId = getString(R.string.web_client)
    oneTapClient = Identity.getSignInClient(requireActivity())
    // Build sign-in request with Google ID token options
    signUpRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(serverClientId)
                .setFilterByAuthorizedAccounts(false)
                .build()
        )
        .build()
        // Set click listener for Google sign-in button
        binding.cardView3.setOnClickListener {
            startSignInIntent()
        }
//        binding.cardView3.setOnClickListener {
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun startSignInIntent() {
        oneTapClient.beginSignIn(signUpRequest)
            .addOnSuccessListener { result ->
                try {
                    val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                    activityResultLauncher.launch(intentSenderRequest)
                } catch (e: IntentSender.SendIntentException) {
                    Log.e("OneTap", "Couldn't start One Tap UI: ${e.localizedMessage}")
                }
            }
            .addOnFailureListener { e ->
                Log.d("OneTap", e.localizedMessage ?: "Unknown error")
                Toast.makeText(requireContext(), "Sign In Failed", Toast.LENGTH_SHORT).show()
            }
    }
}