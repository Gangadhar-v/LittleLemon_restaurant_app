@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.littlelemon

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffold(drawerState:DrawerState,scope:CoroutineScope) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { scope.launch { if(drawerState.isClosed) drawerState.open() }}) {
                        Icon(modifier=Modifier.size(40.dp),
                            imageVector = Icons.Default.Menu,
                            contentDescription = "hamburger Menu"
                        )
                    }
                },title ={
                    title()
                }
            )
        },content ={ mainScreen() }
    )


}
@Composable
fun title(){
    Row() {
        Image(modifier= Modifier
            .weight(.8f)
            .height(40.dp) ,painter = painterResource(id =R.drawable.ll  ) , contentDescription =null )
        Image(modifier= Modifier
            .weight(.2f)
            .size(40.dp) ,painter = painterResource(id =R.drawable.shoppingcart) , contentDescription =null )
    }
}

@Preview
@Composable
fun previewScaffold(){
    val drawerState = rememberDrawerState(initialValue =DrawerValue.Closed )
    val scope= rememberCoroutineScope()
    scaffold(drawerState,scope)
}



