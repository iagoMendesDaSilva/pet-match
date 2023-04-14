package com.iago.petmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.firebase.analytics.FirebaseAnalytics
import com.iago.petmatch.navigation.Navigation
import com.iago.petmatch.ui.theme.PetMatchTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)
        val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val configuration = RequestConfiguration.Builder()
            .setTestDeviceIds(Collections.singletonList("DEVICE ID"))
            .build()
        MobileAds.setRequestConfiguration(configuration)
        setContent {
            PetMatchTheme {
                Navigation(firebaseAnalytics)
            }
        }
    }
}