package modulo_05.ejercicio_09

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import modulo_05.ejercicio_09.components.MyButton
import modulo_05.ejercicio_09.components.MySegmentedButton
import modulo_05.ejercicio_09.components.MyText
import modulo_05.ejercicio_09.components.MyTextField


@Composable
fun MainScreen(paddingValues: PaddingValues) {

    val bottomPadding = WindowInsets.systemBars
                                  .asPaddingValues()
                                  .calculateBottomPadding()
    Column(
        modifier = Modifier

            .fillMaxWidth()
            .padding(paddingValues)
            .padding(top = 16.dp),// Padding del Scaffold

        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(){
            MyText(text = stringResource(id=R.string.tituloApp))
            Image(
                painter = painterResource(id = R.drawable.coyote),
                contentDescription = "Marca",
                modifier = Modifier.size(40.dp))
        }

        MySegmentedButton()

        MyTextField(onValueChange = {}, label = stringResource(id = R.string.edad) )
        MyTextField(onValueChange = {}, label = stringResource(id = R.string.peso))
        MyTextField(onValueChange = {}, label = stringResource(id = R.string.altura))
        MyButton(text = stringResource(id = R.string.calcular))


    }
}

