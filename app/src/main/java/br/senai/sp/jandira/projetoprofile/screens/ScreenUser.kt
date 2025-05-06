package br.senai.sp.jandira.projetoprofile.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.projetoprofile.R

@Composable
fun ScreenUser(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = stringResource(id = R.string.background_image_description),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 38.dp, start = 12.dp, end = 12.dp)
                    .align(Alignment.TopStart)
                    .clickable {
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_button_desc),
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.details),
                    color = Color.White,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(1.18f))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.boy_profile),
                    contentDescription = stringResource(id = R.string.profile_image_description),
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(id = R.string.user_name_jenny),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.user_title_designer),
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 10.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ActionCard(
                    icon = Icons.Filled.Email,
                    text = stringResource(id = R.string.email_action),
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp
                )

                ActionCard(
                    icon = Icons.Filled.Call,
                    text = stringResource(id = R.string.call_action),
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp
                )

                ActionCard(
                    icon = Icons.Filled.Whatsapp,
                    text = stringResource(id = R.string.whatsapp_action),
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp
                )

                ActionCard(
                    icon = Icons.Filled.StarBorder,
                    text = stringResource(id = R.string.favorite_action),
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp
                )
            }
        }

        // Fora da Box: Informações de contato
        UserContactInfo()
    }
}

@Composable
fun ActionCard(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    borderColor: Color = Color.Transparent,
    fixedSize: Dp = 70.dp
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(12.dp))
            .clickable { println("$text clicado!") }
            .size(fixedSize)
            .padding(vertical = 0.dp, horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 9.sp
        )
    }
}

@Composable
fun UserContactInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        ContactSection(
            title = stringResource(id = R.string.email),
            items = listOf(
                stringResource(id = R.string.official) to "michael.mitc@example.com",
                stringResource(id = R.string.personal) to "michael@example.com"
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        ContactSection(
            title = stringResource(id = R.string.phone_number),
            items = listOf(stringResource(id = R.string.mobile) to "(209) 555-0104")
        )

        Spacer(modifier = Modifier.height(12.dp))

        ContactSectionWithArrow(
            title = stringResource(id = R.string.team),
            subtitle = stringResource(id = R.string.project_operation_team)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ContactSectionWithArrow(
            title = stringResource(id = R.string.leads_by),
            subtitle = "Darrell Steward"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(text = stringResource(id = R.string.add_to_contact))
            ActionButton(text = stringResource(id = R.string.share))
        }
    }
}

@Composable
fun ContactSection(title: String, items: List<Pair<String, String>>) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        items.forEach { (label, value) ->
            Text(text = label, color = Color.Gray, fontSize = 12.sp)
            Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ContactSectionWithArrow(title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = subtitle, fontSize = 14.sp, color = Color.Gray)
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = stringResource(id = R.string.view_details),
            tint = Color.Gray
        )
    }
}

@Composable
fun ActionButton(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFE0E0E0))
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 24.dp)
    ) {
        Text(text = text, fontSize = 14.sp, color = Color.Black)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScreenUserPreview() {
    ScreenUser()
}
