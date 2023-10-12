package isel.game.gomoku.ui.screens.about

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import isel.game.gomoku.R
import isel.game.gomoku.ui.screens.daily.TAG

class AboutActivity : ComponentActivity() {

    companion object {
        fun navigateTo(origin: Activity) {
            val intent = Intent(origin, AboutActivity::class.java)
            origin.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutScreen(
                onSendEmailRequested = { openSendEmail(it) },
                onOpenUrlRequested = { openURL(it) },
                bottomBarOption= listOf(),
                authors = authorInfo,
            )
        }
    }

    private fun openURL(uri: Uri) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        catch (e: ActivityNotFoundException) {
            Log.e(TAG, "Failed to open URL", e)
            Toast
                .makeText(
                    this,
                    R.string.activity_info_no_suitable_app,
                    Toast.LENGTH_LONG
                )
                .show()
        }
    }

    private fun openSendEmail(email:String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, email)
                putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUBJECT)
            }

            startActivity(intent)
        }
        catch (e: ActivityNotFoundException) {
            Log.e(TAG, "Failed to send email", e)
            Toast
                .makeText(
                    this,
                    R.string.activity_info_no_suitable_app,
                    Toast.LENGTH_LONG
                )
                .show()
        }
    }
}

val authorInfo = listOf(
    AuthorInfo(
        name = "Rafael Costa",
        email = "A48315@alunos.isel.pt",
        imageId = R.drawable.ic_author,
        git = Uri.parse("https://github.com/Rafael4DC")
    ),
    AuthorInfo(
        name = "Bernardo Serra",
        email = "A48315@alunos.isel.pt",
        imageId = R.drawable.ic_armario,
        git = Uri.parse("https://github.com/bfmserra")
    )
)

private const val EMAIL_SUBJECT = "About the Jokes App"