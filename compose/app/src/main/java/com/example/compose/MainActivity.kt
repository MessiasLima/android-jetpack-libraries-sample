package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxHeight()) {
                NewStory()
            }
        }
    }
}

@Composable
fun NewStory() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        RoundedImage()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
            style = MaterialTheme.typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "Davenport, California", style = MaterialTheme.typography.body2)
        Text(text = "December 2018", style = MaterialTheme.typography.body2)
    }
}

@Composable
fun RoundedImage() {
    Image(
        painter = painterResource(id = R.drawable.header),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NewStory()
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    RoundedImage()
}