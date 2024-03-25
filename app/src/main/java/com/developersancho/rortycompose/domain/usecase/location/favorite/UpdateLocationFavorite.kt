package com.developersancho.rortycompose.domain.usecase.location.favorite

import androidx.annotation.VisibleForTesting
import com.developersancho.framework.extension.orZero
import com.developersancho.framework.usecase.LocalUseCase
import com.developersancho.rortycompose.data.model.dto.location.LocationDto
import com.developersancho.rortycompose.data.model.dto.location.toLocationEntity
import com.developersancho.rortycompose.data.repository.location.LocationRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class UpdateLocationFavorite @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: LocationRepository
) : LocalUseCase<UpdateLocationFavorite.Params, Unit>() {

    data class Params(
        val location: LocationDto
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val dto = params.location
        val character = repository.getFavorite(dto.id.orZero())
        if (character == null) {
            repository.saveFavorite(dto.toLocationEntity())
        } else {
            repository.deleteFavoriteById(dto.id.orZero())
        }
        emit(Unit)
    }
}