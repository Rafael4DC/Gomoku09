package isel.game.gomoku.ui.screens.ranking

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import isel.game.gomoku.service.app.FakeRankingService
import isel.game.gomoku.ui.screens.home.TAG

class RankingActivity : ComponentActivity() {

    companion object {
    fun navigateTo(origin: Activity) {
        val intent = Intent(origin, RankingActivity::class.java)
        origin.startActivity(intent)
    }
}
    private val viewModel by viewModels<RankingViewModel>()
    private val service = FakeRankingService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchRankers(service)
        Log.v(TAG, "onCreateR() called")
        setContent {
            RankingScreen(
                rankers = viewModel.rankers,
                onBackRequest = { finish() },
            )
        }
    }
    override fun onStart() {
        super.onStart()
        Log.v(isel.game.gomoku.ui.screens.home.TAG, "onStartR() called")
    }
}
