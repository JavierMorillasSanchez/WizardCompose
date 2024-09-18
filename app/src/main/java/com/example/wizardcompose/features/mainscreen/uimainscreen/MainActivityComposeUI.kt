package com.example.wizardcompose.features.mainscreen.uimainscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wizardcompose.R
import com.example.wizardcompose.dataclasses.elixirclasses.Elixir
import com.example.wizardcompose.dataclasses.houseclasses.House
import com.example.wizardcompose.dataclasses.wizardclasses.Wizard
import com.example.wizardcompose.features.mainscreen.viewmodel.MainActivityViewModel
import com.example.wizardcompose.utils.ObjectListType

@Composable
fun MainActivityComposeUIGenerator(viewModel: MainActivityViewModel, context: Context){

    val houseList = remember { mutableStateListOf<House>() }
    val isHouseListPrepared = viewModel.getHouseListPreparedValue().observeAsState(initial = false)

    val wizardList = remember { mutableStateListOf<Wizard>() }
    val isWizardListPrepared = viewModel.getWizardListPreparedValue().observeAsState(initial = false)

    val elixirList = remember { mutableStateListOf<Elixir>() }
    val isElixirListPrepared = viewModel.getElixirListPreparedValue().observeAsState(initial = false)

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

            Text(text = stringResource(id = R.string.the_four_houses_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )

            if (isHouseListPrepared.value) {

                if(houseList.isEmpty()){
                    houseList.addAll(viewModel.getAllHouseList())
                }

                LoadCoatOfArmsFromEachHouse(houseList, context)
            }

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Text(text = stringResource(id = R.string.renamed_wizards_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

            if (isWizardListPrepared.value) {

                if(wizardList.isEmpty()){
                    wizardList.addAll(viewModel.getAllWizardsList())
                }

                LoadAllWizards(wizardList, context)
            }

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Text(text = stringResource(id = R.string.elixirs_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

            if (isElixirListPrepared.value) {

                if(elixirList.isEmpty()){
                    elixirList.addAll(viewModel.getAllElixirList())
                }

                LoadAllElixirs(elixirList, context)
            }

        }

    }

}

@Composable
fun LoadCoatOfArmsFromEachHouse(houseList: SnapshotStateList<House>, context: Context){

    val imageList = listOf(
        R.drawable.griffindor_logo,
        R.drawable.slytherin_logo,
        R.drawable.hufflepuf_logo,
        R.drawable.ravenclaw_logo
    )

    Box(modifier = Modifier.fillMaxWidth()) {

        Column(Modifier.fillMaxWidth()) {

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
                                        .background(Color.Transparent)
                                        .clickable {
                                            Toast
                                                .makeText(
                                                    context,
                                                    "Navegamos a las casas",
                                                    Toast.LENGTH_SHORT
                                                )
                                                .show()
                                        }
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
fun LoadAllWizards(wizardList: SnapshotStateList<Wizard>, context: Context) {

    Box(modifier = Modifier.fillMaxWidth()) {

        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())) {

                for ((index, wizard) in wizardList.take(9).withIndex()){
                    CustomWizardCell(
                        wizardName = wizard.firstName,
                        wizardSurname = wizard.lastName,
                        amountOfElixirs = wizard.elixirs.size
                    )

                    if(index == 8){
                        NavigateToFullListCell(context = context, ObjectListType.WIZARD)
                    }
                }
        }
    }

}

@Composable
fun LoadAllElixirs(elixirList: SnapshotStateList<Elixir>, context: Context) {

    Box(modifier = Modifier.fillMaxWidth()) {

        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())) {

            for ((index, elixir) in elixirList.take(9).withIndex()){
                CustomElixirCell(
                    elixirName = elixir.name,
                    elixirEffect = elixir.effect
                )

                if(index == 8){
                    NavigateToFullListCell(context = context,  ObjectListType.ELIXIR)
                }
            }
        }
    }
}

@Composable
fun CustomWizardCell(
    wizardName: String?,
    wizardSurname: String?,
    amountOfElixirs: Int?
){

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .border(1.dp, Color.Red, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row {

                Text (
                    text = wizardName ?: "",
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = if(wizardName != null) Modifier.padding(end = 8.dp) else Modifier.padding(end = 0.dp)
                )

                Text(text = wizardSurname ?: "",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
            }

            Row {

                Text(text = stringResource(id = R.string.number_of_elixirs_title),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp)
                )

                Text(text = let { amountOfElixirs.toString() },
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp)
                )
            }
        }
    }
}

@Composable
fun CustomElixirCell(
    elixirName: String?,
    elixirEffect: String?,
){

    Box(
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
            .height(200.dp)
            .background(color = Color.White)
            .border(1.dp, Color.Green, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row {

                Text(text = elixirName ?: "Sin nombre.",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(end = 15.dp)
                )
            }

            Row {

                Text(text = elixirEffect ?: "Sin descripción",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(end = 15.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun NavigateToFullListCell(
    context: Context,
    showMoreListType: ObjectListType
){

    val navigateToFullList = "Navegamos a $showMoreListType full list"

    Box(
        modifier =  when(showMoreListType) {
            ObjectListType.WIZARD -> Modifier
                .padding(16.dp)
                .width(70.dp)
                .height(70.dp)
                .background(color = Color.White)
                .border(1.dp, Color.Red, shape = RoundedCornerShape(8.dp))

            ObjectListType.ELIXIR -> Modifier
                                        .padding(16.dp)
                                        .width(200.dp)
                                        .height(200.dp)
                                        .background(color = Color.White)
                                        .border(1.dp, Color.Green, shape = RoundedCornerShape(8.dp))

            else -> { Modifier
                        .padding(0.dp)
                        .width(0.dp)
                        .height(0.dp) }
        }
    ) {
        Image(painter = painterResource(id = R.drawable.plus_simbol),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.Center)
                .clickable {
                    Toast
                        .makeText(
                            context,
                            navigateToFullList,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
        )
    }
}