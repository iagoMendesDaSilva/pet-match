package com.iago.petmatch.screens.home.commons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.iago.petmatch.BuildConfig

@Composable
fun BannerAdView() {

    val idBanner = BuildConfig.AD_MOB_TEST_BANNER_ID

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                adUnitId = idBanner
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}