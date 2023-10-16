package isel.game.gomoku.service.app

import android.util.Log
import isel.game.gomoku.domain.app.Joke
import isel.game.gomoku.domain.app.Ranker
import isel.pdm.jokes.daily.TAG
import kotlinx.coroutines.delay
import java.net.URL
import kotlin.random.Random

/**
 * Contract of the service that provides jokes
 */
interface RankingService {
    /**
     * Fetches a joke from the service
     */
    suspend fun getRankers(limit: Int): List<Ranker>
}

/**
 * Fake implementation of the JokesService. It will replaced by a real implementation
 * in a future lecture.
 */
class FakeRankingService : RankingService {

    private val rankings = listOf(
        Ranker(
            username = "Chuck Norris",
            score = 100,
            400,
        ),
        Ranker(
            username = "Bruce Lee",
            score = 90,
            300,
        ),
        Ranker(
            username = "Jackie Chan",
            score = 80,
            200,
        ),
        Ranker(
            username = "Jet Li",
            score = 70,
            100,
        ),
    )

    override suspend fun getRankers(limit: Int): List<Ranker> {
        Log.v(TAG, "fetching rankers...")
        delay(3000)
        return rankings
    }
}

object NoOpRankService : RankingService {
    override suspend fun getRankers(limit: Int): List<Ranker> = listOf(
        Ranker(
            username = "Chuck Norris",
            score = 100,
            400,
        ),
        Ranker(
            username = "Bruce Lee",
            score = 90,
            300,
        ),
        Ranker(
            username = "Jackie Chan",
            score = 80,
            200,
        ),
        Ranker(
            username = "Jet Li",
            score = 70,
            100,
        ),
    )
}