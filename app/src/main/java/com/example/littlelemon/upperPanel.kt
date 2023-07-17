package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun upperPanel(paddingValues: PaddingValues) {
    val context= LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xff475749))
            .padding(top=paddingValues.calculateTopPadding(),start=5.dp,end=5.dp,bottom=5.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = "Little Lemon",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xffFaf536)
        )
        Text(
            modifier = Modifier,
            text = "Karnataka",
            fontSize = 20.sp,
            color = Color.White
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {

            Text(
                modifier = Modifier
                    .weight(.5f)
                    .height(100.dp),
                text = "We are a family owned Mediterranean " +
                        "restaurant focused on traditional recipes" +
                        " served with modern twist.",
                fontSize = 15.sp,
                color = Color.White
            )
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp)
                    .weight(.5f)
                    .clip(RoundedCornerShape(30.dp)),
                painter = painterResource(id = R.drawable.dosa),
                contentDescription = null
            )
        }
        Button(onClick = { Toast.makeText(context,"Order Taken",Toast.LENGTH_SHORT ).show() }, colors = ButtonDefaults.buttonColors(Color(0xffFaf536))) {
            Text(
                text = "Order Take Away",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    LittleLemonTheme {
        upperPanel(paddingValues= PaddingValues(top=40.dp) )
    }
}