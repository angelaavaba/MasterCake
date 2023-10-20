import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angelaavalos.mastercake.R


@Composable
fun OnboardingTest() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.pastel3),
            contentDescription = "Imagen de pastel 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 8.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Disfruta nuestros postres",
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 30.sp
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )


            Text(
                text = "Los mejores del mundo",
                style = MaterialTheme.typography.subtitle1.copy(
                    color = Color.White,
                    fontSize = 21.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Button(
                onClick = { /* Acción cuando se presiona el botón Skip */ },
                modifier = Modifier
                    .align(Alignment.End)
                    .widthIn(80.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFFA0522D), shape = RoundedCornerShape(24.dp)),
            ) {
                Text(text = "Skip", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun Onboarding1Preview() {
    OnboardingTest()


}


