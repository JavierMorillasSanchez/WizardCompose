package com.example.wizardcompose.features.mainscreen.uimainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wizardcompose.R

@Composable
fun mainActivityComposeUIGenerator(){

    loadCoatOfArmsFromEachHouse()

}

@Composable
fun loadCoatOfArmsFromEachHouse(){
    val imageList = listOf(
        R.drawable.griffindor_logo,
        R.drawable.slytherin_logo,
        R.drawable.hufflepuf_logo,
        R.drawable.ravenclaw_logo
    )

    Box(modifier = Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxWidth()) {
            
            Text(text = stringResource(id = R.string.the_four_houses),
            modifier = Modifier
                .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )

            LazyVerticalGrid(GridCells.Fixed(2)) {
                items(4) { index ->
                    Image(
                        painter = painterResource(imageList[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f) // Mantener la relación de aspecto 1:1
                            .clip(shape = RoundedCornerShape(8.dp)) // Recortar las esquinas si es necesario
                            .padding(8.dp) // Agregar espacio entre las imágenes
                            .fillMaxWidth()
                    )
                }
            }

        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun previewMainActivityComposeUIGenerator(){
    mainActivityComposeUIGenerator()
}