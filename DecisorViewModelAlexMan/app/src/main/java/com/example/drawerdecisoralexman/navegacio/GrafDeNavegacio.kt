package com.example.drawerdecisoralexman.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.drawerdecisoralexman.ui.pantalles.Instruccions
import com.example.drawerdecisoralexman.ui.pantalles.Match
import com.example.drawerdecisoralexman.ui.pantalles.Portada
import com.example.drawerdecisoralexman.ui.pantalles.Preferencies
import com.example.drawerdecisoralexman.ui.pantalles.QuantA


@Composable
fun GrafDeNavegacio (
    controladorDeNavegacio: NavHostController = rememberNavController(),
    paddingValues: PaddingValues
)
{
    NavHost(navController = controladorDeNavegacio, startDestination =CategoriaDeNavegacio.Portada.rutaPrevia)
    {
        navigation(startDestination = Destinacio.Portada.rutaBase,route =CategoriaDeNavegacio.Portada.rutaPrevia )
        {
            composable(route = Destinacio.Portada.rutaGenerica){
                Portada()
            }
        }

        navigation(startDestination = Destinacio.Instruccions.rutaBase,route =CategoriaDeNavegacio.Instruccions.rutaPrevia )
        {
            composable(route = Destinacio.Instruccions.rutaGenerica){
                Instruccions()
            }
        }
        navigation(startDestination = Destinacio.Preferencies.rutaBase,route =CategoriaDeNavegacio.Preferencies.rutaPrevia)
        {
            composable(route = Destinacio.Preferencies.rutaGenerica){
                Preferencies()
            }
        }
        navigation(startDestination = Destinacio.QuantA.rutaBase,route =CategoriaDeNavegacio.QuantA.rutaPrevia)
        {
            composable(route = Destinacio.QuantA.rutaGenerica){
                QuantA()
            }
        }
        navigation(startDestination = Destinacio.Match.rutaBase,route =CategoriaDeNavegacio.Match.rutaPrevia)
        {
            composable(route = Destinacio.Match.rutaGenerica){
                Match()
            }
        }

        }
}
