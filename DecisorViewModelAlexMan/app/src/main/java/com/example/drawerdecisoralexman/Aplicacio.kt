package com.example.drawerdecisoralexman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.drawerdecisoralexman.navegacio.CategoriaDeNavegacio
import com.example.drawerdecisoralexman.navegacio.Destinacio
import com.example.drawerdecisoralexman.navegacio.GrafDeNavegacio
import com.example.drawerdecisoralexman.ui.theme.DrawerDecisorAlexManTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun PantallaDeLAplicacio (content: @Composable ()->Unit)
{
    DrawerDecisorAlexManTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aplicacio (content: @Composable ()-> Unit = { Text ("") })
{
    val controladorDeNavegacio = rememberNavController()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val navBackStackEntry by controladorDeNavegacio.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route ?: ""
    val estatDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)

    DrawerSencer(controladorDeNavegacio, estatDrawer, rutaActual, coroutineScope)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerSencer(
    controladorDeNavegacio: NavHostController = rememberNavController(),
    estatDrawer: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    rutaActual: String,
    coroutineScope: CoroutineScope
) {
    ModalNavigationDrawer(
        drawerState = estatDrawer,
        gesturesEnabled = rutaActual in listOf(
            Destinacio.Portada.rutaGenerica,
            Destinacio.Instruccions.rutaGenerica,
            Destinacio.Match.rutaGenerica,
            Destinacio.Preferencies.rutaGenerica
        ),
        drawerContent = {
            ModalDrawerSheet (
                drawerShape = ShapeDefaults.ExtraSmall,
                drawerContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                drawerContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                drawerTonalElevation = 10.dp,
                windowInsets = WindowInsets(
                    left = 24.dp,
                    top= 48.dp,
                    right = 24.dp
                )
            ){
                Image(
                    painter = painterResource(id = R.drawable.spock),
                    contentDescription ="",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth)
                Spacer(modifier = Modifier.weight(1F))
                CategoriaDeNavegacio.values().forEach {
                    NavigationDrawerItem(
                        label = { Text (it.titol)},
                        icon = { Icon(imageVector = it.icona,it.titol) },
                        selected = rutaActual.contains(it.rutaPrevia) ,
                        onClick = {
                            coroutineScope.launch {
                                estatDrawer.close()
                            }
                            controladorDeNavegacio.navigate(it.rutaPrevia) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            unselectedBadgeColor = MaterialTheme.colorScheme.error,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            selectedIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                            selectedBadgeColor = MaterialTheme.colorScheme.error
                        ),
                        shape = ShapeDefaults.ExtraSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Spacer(modifier = Modifier.weight(1F))
            }
        }) {
        Contingut(
            controladorDeNavegacio = controladorDeNavegacio,
            rutaActual = rutaActual,
            estatDrawer, coroutineScope)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contingut(
    controladorDeNavegacio: NavHostController,
    rutaActual: String,
    estatDrawer: DrawerState,
    coroutineScope: CoroutineScope
)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Portada") },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    if(rutaActual == Destinacio.Portada.rutaGenerica) {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                if (estatDrawer.isOpen) {
                                    estatDrawer.close()
                                } else {
                                    estatDrawer.open()
                                }
                            }
                        }) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                    else{
                        IconButton(onClick = { controladorDeNavegacio.navigateUp()}) {

                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                })
        }

    )
    {paddingValues ->
        GrafDeNavegacio(controladorDeNavegacio, paddingValues)
    }
}