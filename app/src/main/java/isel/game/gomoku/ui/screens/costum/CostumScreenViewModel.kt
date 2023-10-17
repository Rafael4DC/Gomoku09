package isel.game.gomoku.ui.screens.costum

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import isel.game.gomoku.domain.app.Ranker
import isel.game.gomoku.domain.game.GameRules
import isel.game.gomoku.service.app.RankingService
import kotlinx.coroutines.launch

class CostumViewModel : ViewModel() {

    var gameRules: GameRules by mutableStateOf(GameRules())

    /*fun fetchRankers(service: RankingService) {
        viewModelScope.launch {
            rankers = service.getRankers(3)
        }
    }*/
}