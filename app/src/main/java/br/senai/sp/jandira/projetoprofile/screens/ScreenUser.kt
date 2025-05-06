package br.senai.sp.jandira.projetoprofile.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Whatsapp
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
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            // Imagem de fundo
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "Imagem de fundo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Sobreposição escura
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            // Row com a seta e o texto
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 38.dp, start = 12.dp, end = 12.dp)
                    .align(Alignment.TopStart)
                    .clickable {
                        println("Voltar clicado!")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
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

            // Column com a imagem de perfil e os textos
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.boy_profile),
                    contentDescription = "Imagem de perfil",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Jenny Wilson",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sr.UI/UX Designer",
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            // CARDS ADICIONADOS DENTRO DA BOX
            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 10.dp,)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ActionCard(
                    icon = Icons.Filled.Email,
                    text = "Email",
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp // Tamanho menor para o card de Email
                )

                ActionCard(
                    icon = Icons.Filled.Call,
                    text = "Call",
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp // Tamanho menor para o card de Call
                )

                ActionCard(
                    icon = Icons.Filled.Whatsapp,
                    text = "WhatsApp",
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp // Tamanho menor para o card de WhatsApp
                )

                ActionCard(
                    icon = Icons.Filled.StarBorder,
                    text = "Favorite",
                    backgroundColor = Color.Transparent,
                    borderColor = Color.White,
                    fixedSize = 60.dp // Tamanho menor para o card de Favorite
                )
            }
        }
    }
}

@Composable
fun ActionCard(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    borderColor: Color = Color.Transparent,
    fixedSize: Dp = 70.dp // Novo parâmetro para o tamanho fixo
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(12.dp))
            .clickable { /* Ação ao clicar */ }
            .size(fixedSize) // Aplica o tamanho fixo ao Column
            .padding(vertical = 0.dp, horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centraliza o conteúdo verticalmente
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

@Preview(showSystemUi = true)
@Composable
private fun ScreenUserPreview() {
    ScreenUser()
}