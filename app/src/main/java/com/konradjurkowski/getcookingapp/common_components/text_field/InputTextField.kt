package com.konradjurkowski.getcookingapp.common_components.text_field

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.konradjurkowski.getcookingapp.R

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String,
    enabled: Boolean = true,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    autocorrect: Boolean = false,
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        placeholder = {
            Text(text = placeholder)
        },
        textStyle = MaterialTheme.typography.h6,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_corner_shape_size)),
        enabled = enabled,
        visualTransformation = visualTransformation,
        maxLines = 1,
        singleLine = true,
        isError = isError,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = keyboardType,
            autoCorrect = autocorrect
        ),
    )
}