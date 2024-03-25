package com.developersancho.rortycompose.domain.usecase.location.favorite

import androidx.annotation.VisibleForTesting
import com.developersancho.framework.usecase.LocalUseCase
import com.developersancho.rortycompose.data.model.dto.location.LocationDto
import com.developersancho.rortycompose.data.model.dto.location.toLocationEntity
import com.developersancho.rortycompose.data.repository.location.LocationRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AddLocationFavorite @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: LocationRepository
) : LocalUseCase<AddLocationFavorite.Params, Unit>() {

    data class Params(
        val location: LocationDto
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val dto = params.location
        repository.saveFavorite(dto.toLocationEntity())
        emit(Unit)
    }
}