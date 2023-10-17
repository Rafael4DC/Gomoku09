package isel.game.gomoku.ui.screens.ranking

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import isel.game.gomoku.domain.app.Ranker
import isel.game.gomoku.service.app.RankingService
import kotlinx.coroutines.launch

class RankingViewModel : ViewModel() {

    var rankers: List<Ranker>? by mutableStateOf(null)
        private set

    fun fetchRankers(service: RankingService) {
        viewModelScope.launch {
            rankers = service.getRankers(3)
        }
    }
}