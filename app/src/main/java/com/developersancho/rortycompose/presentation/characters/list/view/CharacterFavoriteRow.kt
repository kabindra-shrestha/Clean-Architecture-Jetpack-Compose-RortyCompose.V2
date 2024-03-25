package com.developersancho.rortycompose.presentation.characters.list.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.developersancho.rortycompose.app.theme.JetRortyTheme
import com.developersancho.rortycompose.app.theme.JetRortyTypography
import com.developersancho.rortycompose.app.theme.RedDark
import com.developersancho.rortycompose.data.model.dto.character.CharacterDto

@Composable
fun CharacterFavoriteRow(
    modifier: Modifier = Modifier,
    dto: CharacterDto,
    onDetailClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    Card(
        onClick = onDetailClick,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = 8.dp
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dto.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(size = 8.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(top = 12.dp, start = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = dto.name,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                    style = JetRortyTypography.subtitle1
                )
                Text(
                    text = dto.species.toString(),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp),
                    style = JetRortyTypography.subtitle1
                )
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CharacterStatusDotView(character = dto)
                        Text(
                            text = dto.status.value,
                            maxLines = 1,
                            overflow = TextOverflow.Visible,
                            style = JetRortyTypography.body2,
                            modifier = modifier
                        )
                    }
                }
            }

            IconButton(
                onClick = onDeleteClick,
                modifier = modifier
                    .width(34.dp)
                    .height(34.dp)
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.Default.Delete),
                    contentDescription = null,
                    tint = RedDark
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun CharacterFavoriteRowPreview() {
    JetRortyTheme {
        CharacterFavoriteRow(dto = CharacterDto.init())
    }
}