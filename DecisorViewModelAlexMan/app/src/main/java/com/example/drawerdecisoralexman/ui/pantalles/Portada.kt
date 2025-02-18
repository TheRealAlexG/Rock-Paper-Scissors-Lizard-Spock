package com.example.drawerdecisoralexman.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drawerdecisoralexman.R

@Preview
@Composable
fun Portada(onClick:()->Unit={})
{
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(48.dp),
    )
    {
        Spacer(modifier = Modifier.height(20.dp))
        Image (
            painterResource(id = R.drawable.logo_vermell),
            contentDescription = null,
            modifier = Modifier.height(150.dp)
                .width(150.dp),
            contentScale = ContentScale.FillWidth)

        Spacer (Modifier.weight(1F))
        Image(painterResource(id = R.drawable.spock), contentDescription="Decissor")
        Spacer (Modifier.weight(1F))
        Text(text = "Pedra Paper Tisores Spock",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)
        Spacer (Modifier.weight(1F))

    }


}