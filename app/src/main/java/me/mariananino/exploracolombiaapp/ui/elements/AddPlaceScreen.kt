package me.mariananino.exploracolombiaapp.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddPlaceScreen(
    onBackClick: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    val fondo = Color(0xFFF8F3F8)
    val rojo = Color(0xFFA6190D)
    val naranja = Color(0xFFFF6943)
    val caja = Color(0xFFE4DFE4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = rojo,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = "AddPlace",
                color = rojo,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .shadow(10.dp, RoundedCornerShape(38.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(rojo, naranja)
                    ),
                    shape = RoundedCornerShape(38.dp)
                )
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Comparte tu\ndescubrimiento",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 28.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Ayuda a otros viajeros a encontrar los tesoros\nescondidos de nuestra tierra.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(26.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(34.dp))
                .background(Color(0xFFF5F1F5), RoundedCornerShape(34.dp))
                .padding(24.dp)
        ) {

            Campo("NOMBRE DEL LUGAR", "Ej: Cascada del Fin del Mundo", nombre, caja) {
                nombre = it
            }

            Campo("DEPARTAMENTO", "Ej: Putumayo", departamento, caja) {
                departamento = it
            }

            Campo("CIUDAD", "Ej: Mocoa", ciudad, caja) {
                ciudad = it
            }

            Text(
                text = "DESCRIPCIÓN",
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                letterSpacing = 3.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                placeholder = {
                    Text("Cuéntanos por qué este lugar es especial...")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = caja,
                    unfocusedContainerColor = caja,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(28.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .shadow(8.dp, RoundedCornerShape(40.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(rojo, naranja)
                        ),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "▷  Publicar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun Campo(
    titulo: String,
    hint: String,
    valor: String,
    colorCaja: Color,
    cambio: (String) -> Unit
) {
    Text(
        text = titulo,
        color = Color.DarkGray,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = 3.sp
    )

    Spacer(modifier = Modifier.height(12.dp))

    TextField(
        value = valor,
        onValueChange = cambio,
        placeholder = {
            Text(hint)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorCaja,
            unfocusedContainerColor = colorCaja,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )

    Spacer(modifier = Modifier.height(22.dp))
}