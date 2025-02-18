package com.example.drawerdecisoralexman.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun Instruccions()
{
    //LazyColumn
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceVariant))
    {
        Text(text = "Pantalla d'instruccions",
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)

        Spacer (Modifier.height(50.dp))
        Image (
            painterResource(id = R.drawable.instrucctions),
            contentDescription = null,
            modifier = Modifier.width(200.dp)
                .align(Alignment.CenterHorizontally  ),
            contentScale = ContentScale.FillWidth)

        Spacer (Modifier.height(30.dp))


        LazyColumn {
            // Add a single item
            item {
                Text(
                    text = "Piedra: Representada por un puño cerrado. La piedra aplasta la tijera y aplasta al lagarto.\n" +
                            "\n" +
                            "Papel: Representado por una mano extendida. El papel cubre la piedra y desaprueba a Spock.\n" +
                            "\n" +
                            "Tijeras: Representadas por dos dedos extendidos y juntos. Las tijeras cortan el papel y decapitan al lagarto.\n" +
                            "\n" +
                            "Lagarto: Representado por una mano con la forma de una boca abierta. El lagarto come el papel y es envenenado por Spock.\n" +
                            "\n" +
                            "Spock: Representado por la señal de paz y prosperidad de Star Trek. Spock vaporiza la roca y desautoriza a las tijeras.\n" +
                            "\n" +
                            "El juego se juega entre dos personas, y cada una elige una de las cinco opciones al mismo tiempo. Las reglas son:\n" +
                            "\n" +
                            "Piedra aplasta tijeras y lagarto.\n" +
                            "Papel cubre piedra y desaprueba Spock.\n" +
                            "Tijeras cortan papel y decapitan lagarto.\n" +
                            "Lagarto come papel y es envenenado por Spock.\n" +
                            "Spock vaporiza la roca y desautoriza las tijeras.\n" +
                            "Si ambos jugadores eligen la misma opción, el juego es un empate y se puede jugar otra ronda. ¡Diviértete jugando!",
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