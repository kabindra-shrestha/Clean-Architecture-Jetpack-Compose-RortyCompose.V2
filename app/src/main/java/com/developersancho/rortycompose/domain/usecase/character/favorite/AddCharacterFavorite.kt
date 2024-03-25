package com.developersancho.rortycompose.domain.usecase.character.favorite

import androidx.annotation.VisibleForTesting
import com.developersancho.framework.usecase.LocalUseCase
import com.developersancho.rortycompose.data.model.dto.character.CharacterDto
import com.developersancho.rortycompose.data.model.dto.character.toCharacterEntity
import com.developersancho.rortycompose.data.repository.character.CharacterRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AddCharacterFavorite @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : LocalUseCase<AddCharacterFavorite.Params, Unit>() {

    data class Params(
        val character: CharacterDto
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val dto = params.character
        repository.saveFavorite(dto.toCharacterEntity())
        emit(Unit)
    }
}