package com.google.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.myapplication.data.HeroesRepository
import com.google.myapplication.model.Hero
import com.google.myapplication.navigation.MainNavigation
import com.google.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainNavigation()
            }
        }
    }
}

@Composable
fun HeroApp(){
    Scaffold(topBar = { HeroTopBar() }, backgroundColor = MaterialTheme.colors.background) {
        HeroListItem(heroes = HeroesRepository.heroes)
    }
}

@Composable
fun HeroListItem(modifier: Modifier = Modifier, heroes: List<Hero>) {
    LazyColumn {
        items(heroes) { hero ->
            HeroCardItem(hero = hero)
        }
    }
}

@Composable
fun HeroTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.topBar), style = MaterialTheme.typography.h1)
    }
}

@Composable
fun HeroCardItem(modifier: Modifier = Modifier, hero: Hero) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 2.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp, vertical = 5.dp)
        ) {
            HeroContent(heroName = hero.nameRes, heroDescription = hero.descriptionRes)
            Spacer(modifier = modifier.weight(1f))
            ImageIcon(heroDescription = hero.descriptionRes, heroIcon = hero.imageRes)
        }
    }
}

@Composable
fun ImageIcon(
    modifier: Modifier = Modifier,
    @StringRes heroDescription: Int,
    @DrawableRes heroIcon: Int
) {
    Image(
        modifier = modifier
            .padding(vertical = 10.dp)
            .size(80.dp)
            .clip(RoundedCornerShape(10)),
        painter = painterResource(id = heroIcon),
        contentDescription = stringResource(id = heroDescription),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroContent(
    modifier: Modifier = Modifier,
    @StringRes heroName: Int,
    @StringRes heroDescription: Int
) {
    Column(modifier = modifier.width(250.dp)) {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(text = stringResource(id = heroDescription), style = MaterialTheme.typography.body1)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        HeroCardItem(hero = HeroesRepository.heroes[1])
    }
}