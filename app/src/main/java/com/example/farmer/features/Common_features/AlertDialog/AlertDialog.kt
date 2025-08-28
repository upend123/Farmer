package com.example.farmer.features.Common_features.AlertDialog

import android.app.AlertDialog
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AlertDialog(isDeleteCollection: Boolean = true, onChange: (Boolean) -> Unit = {}, text: String = "Are you sure want to delete collection!",
          title: String =  "Delete Collection",onConfirmRequest: () -> UniEt  = {}
){
    AlertDialog(
        onDismissRequest = {
          onChange(false)
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(title)
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmRequest()
             onChange(false)
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onConfirmRequest()
              onChange(false)
            }) {
                Text("Cancel")
            }
        }
    )
}