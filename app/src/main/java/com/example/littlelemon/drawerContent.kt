package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigatioDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope= rememberCoroutineScope()
    val menuList = listOf(
        Icons.Filled.Person to "Person",
        Icons.Filled.Favorite to "Favorite",
        Icons.Filled.Email to "Email",
        Icons.Filled.ExitToApp to "Exit"
    )
    val selectedItem by remember{ mutableStateOf(-1) }

    ModalNavigationDrawer(drawerState =drawerState,drawerContent = {

        ModalDrawerSheet {
            menuList.forEachIndexed { index, pair ->
                NavigationDrawerItem(label = { Row(modifier= Modifier.fillMaxWidth()) {

                   Image(modifier=Modifier,imageVector =pair.first, contentDescription =null )
                   Spacer(modifier =Modifier.width(10.dp)  )
                    Text(modifier=Modifier.padding(top=5.dp) ,text =pair.second )
                } } , selected =selectedItem ==index , onClick = { scope.launch { if(pair.second =="Exit") drawerState.close() } })

            }
        }

    } ) {

        scaffold(drawerState, scope)
    }
}
@Preview
@Composable
fun previewDrawerContent(){
    navigatioDrawer()
}
