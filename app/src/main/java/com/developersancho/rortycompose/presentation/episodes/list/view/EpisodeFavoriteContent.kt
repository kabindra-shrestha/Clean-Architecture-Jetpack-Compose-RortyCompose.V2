package com.developersancho.rortycompose.presentation.episodes.list.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developersancho.framework.extension.orZero
import com.developersancho.rortycompose.data.model.dto.episode.EpisodeDto

@Composable
fun EpisodeFavoriteContent(
    favors: List<EpisodeDto>,
    selectedFavorite: MutableState<EpisodeDto>,
    onDetailItem: (Int) -> Unit = {},
    onDeleteItem: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp),
    ) {
        itemsIndexed(favors, key = { _, item -> item.id.orZero() }) { _, favor ->
            EpisodeFavoriteRow(
                dto = favor,
                onDetailClick = {
                    onDetailItem.invoke(favor.id.orZero())
                },
                onDeleteClick = {
                    selectedFavorite.value = favor
                    onDeleteItem.invoke(favor.id.orZero())
                }
            )
        }
    }
}