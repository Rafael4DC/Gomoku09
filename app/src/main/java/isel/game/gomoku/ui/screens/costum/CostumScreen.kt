package isel.game.gomoku.ui.screens.costum

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isel.game.gomoku.domain.app.Ranker
import isel.game.gomoku.domain.game.DEFAULT_BOARD_SIZE
import isel.game.gomoku.domain.game.DEFAULT_SECONDS_PER_TURN
import isel.game.gomoku.domain.game.GameRules
import isel.game.gomoku.ui.screens.about.AboutScreenTestTag
import isel.game.gomoku.ui.screens.ranking.components.RankingView
import isel.game.gomoku.ui.screens.shared.components.tenso
import isel.game.gomoku.ui.theme.Gomoku9Theme

/**
 * Tags used to identify the components of the JokeScreen in automated tests
 * (see app/src/androidTest/java/isel/pdm/chucknorris/JokeScreenTests.kt)
 */
//const val FetchItTestTag = "FetchItTestTag"
//const val JokeTestTag = "JokeTestTag"
//const val JokeScreenTestTag = "JokeScreenTestTag"

/**
 * Root composable for the screen that displays a joke.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CostumScreen(
    gameRules: GameRules = GameRules(),
    onBackRequest: (() -> Unit) = {},
) {
    var expanded by remember { mutableStateOf(false) }
    Gomoku9Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .testTag(AboutScreenTestTag),
            topBar = { Column {
                Button(
                    onClick = onBackRequest
                ) {
                    Text(text = "Back")
                }
            } },
        ) { innerPadding ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text(text = "Create Game", fontSize = 30.sp, modifier = Modifier.padding(10.dp))

                tenso()

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Save the game rules */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Start")
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateScreenPreview() {
    CostumScreen()
}


