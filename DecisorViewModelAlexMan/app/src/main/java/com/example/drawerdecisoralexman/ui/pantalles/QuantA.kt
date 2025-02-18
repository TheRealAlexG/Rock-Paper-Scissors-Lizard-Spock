package com.example.drawerdecisoralexman.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drawerdecisoralexman.R

@Preview
@Composable
fun QuantA ()
{
    Column(Modifier.fillMaxSize(). background(color = MaterialTheme.colorScheme.surfaceVariant))
    {
        Spacer (Modifier.height(100.dp))
        Text(text = "Quant A",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)

        Image (
            painterResource(id = R.drawable.quanta),
            contentDescription = null,
            modifier = Modifier.width(150.dp)
                .align(Alignment.CenterHorizontally  ),
            contentScale = ContentScale.FillWidth)

        Spacer (Modifier.height(30.dp))


        LazyColumn {
            // Add a single item
            item {
                Text(
                    text = "El joc \"Pedra, paper, tisores, llagart i Spock\" és una variant del clàssic \"pedra, paper o tisores\", popularitzat per la sèrie de televisió \"The Big Bang Theory\". Aquesta versió ampliada inclou dues noves opcions, el llagart i el Spock, que fan que el joc sigui més complex i estratègic.\n" +
                            "\n" +
                            "Cada jugador tria una de les cinc opcions: pedra, paper, tisores, llagart o Spock. La pedra vença les tisores, les tisores tallen el paper, el paper cobreix la pedra, la pedra vença el llagart, el llagart enverina el Spock, el Spock destrossa les tisores, les tisores decapiten el llagart, el llagart menja el paper, el paper refuta el Spock, i finalment, el Spock vaporitza la pedra.\n" +
                            "\n" +
                            "Aquestes regles addicionals fan que el joc sigui més emocionant, ja que hi ha més estratègies i possibilitats de guanyar. \n" + "\"El joc \\\"Pedra, paper, tisores, llagart i Spock\\\" és una variant del clàssic \\\"pedra, paper o tisores\\\", popularitzat per la sèrie de televisió \\\"The Big Bang Theory\\\". Aquesta versió ampliada inclou dues noves opcions, el llagart i el Spock, que fan que el joc sigui més complex i estratègic.\\n\" +\n" +
                            "                            \"\\n\" +\n" +
                            "                            \"Cada jugador tria una de les cinc opcions: pedra, paper, tisores, llagart o Spock. La pedra vença les tisores, les tisores tallen el paper, el paper cobreix la pedra, la pedra vença el llagart, el llagart enverina el Spock, el Spock destrossa les tisores, les tisores decapiten el llagart, el llagart menja el paper, el paper refuta el Spock, i finalment, el Spock vaporitza la pedra.\\n\" +\n" +
                            "                            \"\\n\" +\n" +
                            "                            \"Aquestes regles addicionals fan que el joc sigui més emocionant, ja que hi ha més estratègies i possibilitats de guanyar.\""
                    ,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(20.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,

                    textAlign = TextAlign.Center
                )

            }

        }

    }
}

