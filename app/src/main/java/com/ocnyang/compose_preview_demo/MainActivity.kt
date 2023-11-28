package com.ocnyang.compose_preview_demo

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ocnyang.compose_preview.ComposePreview
import com.ocnyang.compose_preview.PreviewArgument
import com.ocnyang.compose_preview_demo.ui.theme.ComposePreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePreviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(name = "Android", k = KKK(name = "Android", age = 18, work = arrayListOf("Android", "Android", "Android")))
                }
            }
        }
    }
}

@ComposePreview(device = Devices.DESKTOP, apiLevel = 33)
@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    @PreviewArgument(value = "Android")
    name: String,
    @PreviewArgument(value = "KKK(name = \"Android\", age = 18, work = arrayListOf(\"Android\", \"Android\", \"Android\"))")
    k: KKK,
    @PreviewArgument(value = "18")
    age: Int = 0,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(device = Devices.DEFAULT, backgroundColor = Color.RED.toLong())
@Composable
fun GreetingPreview() {
    Greeting(
        name = "Android", k = KKK(name = "Android", age = 18, work = arrayListOf("Android", "Android", "Android"))
    )
}

data class KKK(
    var name: String,
    var age: Int,
    var work: ArrayList<String>
)