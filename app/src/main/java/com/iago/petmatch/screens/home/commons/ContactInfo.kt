package com.iago.petmatch.screens.home.commons

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.iago.petmatch.models.Contact

@Composable
fun ContactInfo(contact: Contact) {

    val context = LocalContext.current

    Row() {
        Icon(
            tint = MaterialTheme.colors.secondary,
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    if (contact.email.isNotEmpty())
                        openEmail(context, contact.email)
                },
            imageVector = Icons.Rounded.Email,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            tint = MaterialTheme.colors.secondary,
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    if (contact.phone.isNotEmpty())
                        openPhone(context, contact.phone)
                },
            imageVector = Icons.Rounded.Phone,
            contentDescription = null,
        )
    }
}

fun openEmail(context: Context, email: String) {
    val intent = Intent(Intent.ACTION_SEND)
    val emailAddress = arrayOf(email)
    intent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
    intent.type = "message/rfc822"
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Log.d("ERROR", e.toString())
    }
}

fun openPhone(context: Context, phone: String) {
    val uri = Uri.parse("tel:$phone")
    val intent = Intent(Intent.ACTION_DIAL, uri)
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Log.d("ERROR", e.toString())
    }
}
