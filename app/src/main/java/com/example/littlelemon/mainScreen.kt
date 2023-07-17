package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//#426457 green
//#Faf536 yellow
@Composable
fun mainScreen() {

    Column(modifier=Modifier.fillMaxSize()) {
        upperPanel(paddingValues =PaddingValues(60.dp))
        lowerPanel()
    }
}
@Preview
@Composable
fun previewMainScreen(){
    mainScreen()
}
