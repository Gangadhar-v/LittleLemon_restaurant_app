package com.example.littlelemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun row(title: String, description: String, image: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xffb8bfb9))
    ) {
        Text(modifier=Modifier.padding(start=5.dp,top=5.dp),text = title, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold , color = Color.Black)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        ) {
            Text(
                modifier = Modifier.weight(.5f).padding(start=5.dp,top=5.dp),
                text = description,
                fontSize = 15.sp,
                color = Color(0xff3f4540),
                fontWeight = FontWeight.SemiBold
            )
            Image(
                modifier = Modifier
                    .weight(.5f)
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)) ,
                painter = painterResource(id = image),
                contentDescription = null
            )
        }
        Text(modifier=Modifier.padding(start=5.dp,bottom=5.dp),
            text = "$12.99", fontSize = 10.sp,
            color = Color(0xff3f4540) ,
            fontWeight = FontWeight.Medium
        )
    }
}

data class item(val title: String, val description: String, val image: Int)

val item1 = item("Vaangi Bath", "Special South indian breakfast,made with rice, brinjal and masala",R.drawable.vangibat )
val item2 = item("Curd Rice", "Special South indian breakfast,made with rice and curd",R.drawable.curdrice )
val item3 = item("Puliyogare", "Special South indian breakfast,made with rice,tamarind and masala",R.drawable.pulihogare )
val item4 = item("Bisibele Bath", "Special South indian breakfast,made with rice, vegetables and masala",R.drawable.karabath )
val items= listOf(item1,item2,item3,item4)
@Composable
fun lowerPanel() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(text = "Weekly Special", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        LazyColumn(){
            items(items){
                item ->
                row(title =item.title , description =item.description , image =item.image  )
            }
        }
    }
}

@Preview
@Composable
fun previewLowerPanel() {
    lowerPanel()
}