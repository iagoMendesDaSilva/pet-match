package com.iago.petmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.analytics.FirebaseAnalytics
import com.iago.petmatch.navigation.Navigation
import com.iago.petmatch.ui.theme.PetMatchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        setContent {
            PetMatchTheme {
                Navigation(firebaseAnalytics)
            }
        }
    }
}