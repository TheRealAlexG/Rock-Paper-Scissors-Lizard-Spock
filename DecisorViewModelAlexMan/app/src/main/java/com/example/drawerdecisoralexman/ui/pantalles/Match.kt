package com.example.drawerdecisoralexman.ui.pantalles

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.drawerdecisoralexman.R
import com.example.drawerdecisoralexman.dades.PreferenciesDataStore


@Composable
fun Match( viewModel:MatchVM = androidx.lifecycle.viewmodel.compose.viewModel()){
    val estat = viewModel.estat
    val context = LocalContext.current
    val preferencies = PreferenciesDataStore(context)
    val modo by preferencies.getModoJoc.collectAsState(initial = 0)
    val rondes by preferencies.getRondesXGuanyar.collectAsState(initial = 0)
    val nom by preferencies.getNomJugador.collectAsState(initial = "Jack")


    var botoActiu = if (modo == 1) true else false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(230,199,248)),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Spacer(modifier = Modifier.height(100.dp))



        Column {
            Text(text = nom +"          " + estat.triaTevaEstat, fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 20.sp))
            Image (
                painterResource(id = estat.imatgeTeva),
                contentDescription = null,
                modifier = Modifier.width(150.dp)
                    .height(150.dp),
                contentScale = ContentScale.FillWidth)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "IA BOT " +"          "+ estat.triaIAEstat, fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 20.sp))
            Image (
                painterResource(id = estat.imatgeIa),
                contentDescription = null,
                modifier = Modifier.width(150.dp)
                    .height(150.dp),
                contentScale = ContentScale.FillWidth)

        }
        Divider(Modifier.fillMaxWidth())
        Column {
            Button(onClick = {
                viewModel.triaTeva = "Pedra"
                viewModel.TriaIA(modo)
                viewModel.Juga(rondes)
            }) {
                Text(text = "Pedra")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.triaTeva = "Paper"
                viewModel.TriaIA(modo)
                viewModel.Juga(rondes) }) {
                Text(text = "Paper")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.triaTeva = "Tisores"
                viewModel.TriaIA(modo)
                viewModel.Juga(rondes) }) {
                Text(text = "Estisores")
            }
        }
        Column {
            Button(onClick = { viewModel.triaTeva = "Llargandaix"
                viewModel.TriaIA(modo)
                viewModel.Juga(rondes) },
                enabled = botoActiu) {
                Text(text = "Llargandaix")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.triaTeva = "Spock"
                viewModel.TriaIA(modo)
                viewModel.Juga(rondes) },
                enabled = botoActiu) {
                Text(text = "Spock")
            }
        }
        Divider(Modifier.fillMaxWidth())
        Row {
            Text(text = "Rounds: " + rondes, fontWeight = FontWeight.Bold) //Numero de rondes
        }
        Row {
            Text(text = "Woned: " + estat.rondesGuanyadesEstat, fontWeight = FontWeight.Bold)
            Text(text = "Loosed: " + estat.rondesPerdudesEstat, fontWeight = FontWeight.Bold)
        }
        Divider(Modifier.fillMaxWidth())
        Row {
            Text(text = "Victories: " + estat.victoriesEstat, fontWeight = FontWeight.Bold)
        }
    }
}

