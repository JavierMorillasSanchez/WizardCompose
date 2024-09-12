package com.example.wizardcompose.features.mainscreen.uimainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wizardcompose.R

@Composable
fun MainActivityComposeUIGenerator(){

    LazyColumn(
        Modifier.fillMaxSize())
    {

        item {

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LoadCoatOfArmsFromEachHouse()

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LoadAllWizards()

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LoadAllElixirs()
        }


    }

}

@Composable
fun LoadCoatOfArmsFromEachHouse(){

    val imageList = listOf(
        R.drawable.griffindor_logo,
        R.drawable.slytherin_logo,
        R.drawable.hufflepuf_logo,
        R.drawable.ravenclaw_logo
    )

    Box(modifier = Modifier.fillMaxWidth()) {

        Column(Modifier.fillMaxWidth()) {
            
            Text(text = stringResource(id = R.string.the_four_houses_title),
            modifier = Modifier
                .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val itemsPerRow = 2

                for (imageStep in imageList.indices step itemsPerRow) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        for (image in imageStep until imageStep + itemsPerRow) {
                            if (image < imageList.size) {
                                Image(
                                    painter = painterResource(id = imageList[image]),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .weight(1f)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun LoadAllWizards(){
    Box(modifier = Modifier.fillMaxWidth()) {

        Column(Modifier.fillMaxWidth()) {

            Text(text = stringResource(id = R.string.renamed_wizards_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

        }
    }
}

@Composable
fun LoadAllElixirs(){
    Box(modifier = Modifier.fillMaxWidth()) {

        Column(Modifier.fillMaxWidth()) {

            Text(text = stringResource(id = R.string.elixirs_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

        }
    }
}

@Composable
fun CustomWizardCell(){

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row {

                Text(text = stringResource(id = R.string.wizard_name),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp)
                )

                Text(text = stringResource(id = R.string.wizard_surname),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }

            Row {

                Text(text = stringResource(id = R.string.number_of_elixirs_title),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp)
                )

                Text(text = stringResource(id = R.string.number_of_elixirs),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp)
                )

            }

        }
    }
}

@Composable
fun CustomElixirCell(){





}

@Composable
@Preview(showSystemUi = true)
fun PreviewCustomWizardCell(){
    CustomWizardCell()
}

@Composable
@Preview(showSystemUi = true)
fun PreviewCustomElixirCell(){
    CustomElixirCell()
}

@Composable
@Preview(showSystemUi = true)
fun PreviewMainActivityComposeUIGenerator(){
    MainActivityComposeUIGenerator()
}