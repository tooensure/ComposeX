package com.example.composex.ui.components


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.size.Scale
import com.example.composex.R



@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    name: String,
    title: String,
    imageUrl: String,
    onCardClick: () -> Unit = { },
    onContactClick: () -> Unit = { },
) {
    var clicked by remember { mutableStateOf(false) }
    var contactClicked by remember { mutableStateOf(false) }
    // Animating the scale based on the clicked state

    val scale by animateFloatAsState(
        targetValue = if (clicked) 1.05f else 1f, // Scale up slightly when clicked
        animationSpec = tween(
            durationMillis = 300, // Animation duration
            easing = FastOutSlowInEasing // Easing curve
        )
    )

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clickable {
                clicked = !clicked
                onCardClick()
            },  // Card is clickable
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            Box() {


                Surface(
                    color =  Color.Transparent,
                    shape = MaterialTheme.shapes.large) {
                    val imageSizer by animateDpAsState(if (contactClicked) 80.dp else 64.dp)

                    AsyncImage(
                        modifier = Modifier
                            .size(imageSizer),
                        model = imageUrl,
                        contentDescription = "Profile Image",
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        error = painterResource(R.drawable.ic_launcher_background),
                    )
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "Profile Image",
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        error = painterResource(R.drawable.ic_launcher_foreground),
                        modifier = Modifier.size(64.dp).clip(CircleShape)
                    )
                }
                // Load profile image dynamically using Coil
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )

            }


            Spacer(modifier = Modifier.width(5.dp))

            // Name and Title
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            // Message Button
            TextButton(onClick = {
                onContactClick()
            }) {
                Text(text = "Contact", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    ProfileCard(
        name = "Shawn Bellazan",
        title = "Software Developer",
        imageUrl ="https://developer.android.com/images/brand/Android_Robot.png",
    )
}
