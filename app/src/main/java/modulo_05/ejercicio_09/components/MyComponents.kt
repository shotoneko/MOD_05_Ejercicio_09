package modulo_05.ejercicio_09.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import modulo_05.ejercicio_09.R

@Composable
fun MyText(text: String){
    Text(
        text = text,
        modifier = Modifier
            .shadow(
                elevation = 2.dp,shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray) // Se agrega un color de fondo
            .padding(8.dp)
    )
}

@Composable
fun MyTextField(
    //text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    TextField(
        value = "",
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.colorPrimary)) // Se agrega un color de fondo
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun MyButton(text: String){
    Button(
        onClick = { },
        colors= ButtonDefaults.buttonColors(containerColor = Color.Blue.copy(alpha = 0.5f))
    ) {
        Text( text = text, color = Color.White)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySegmentedButton() {
    var checkedList by remember { mutableStateOf<List<Int>>(emptyList()) }
    val options = listOf("Hombre", "Mujer")

    MultiChoiceSegmentedButtonRow(
        modifier = Modifier.padding(10.dp)
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = when {
                        label == "Hombre" -> Color.Green.copy(alpha = 0.5f)
                        label == "Mujer" -> Color.Red.copy(alpha = 0.5f)
                        else -> Color.LightGray
                    }
                ),
                onCheckedChange = { isChecked ->
                    checkedList = if (isChecked) listOf(index) else emptyList()
                },
                checked = index in checkedList
            ) {
                Text(label)
            }
        }
    }
}