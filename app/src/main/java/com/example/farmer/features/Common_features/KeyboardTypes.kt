package com.example.farmer.features.Common_features

import androidx.compose.ui.text.input.KeyboardType

enum class KeyboardTypes(val types: KeyboardType) {
    Text(types = KeyboardType.Text),
    Number(types = KeyboardType.Number),
    NumberPassword(types = KeyboardType.NumberPassword),
    Password(types = KeyboardType.Password),
    Email(types = KeyboardType.Email),
    Uri(types = KeyboardType.Uri),
    Phone(types = KeyboardType.Phone),
    Unspecified(types = KeyboardType.Unspecified),
    Ascii(types = KeyboardType.Ascii),
    Decimal(types = KeyboardType.Decimal),

}