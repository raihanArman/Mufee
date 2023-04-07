package com.example.mufee.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mufee.domain.usecase.GetMoviePopularUseCase
import com.example.mufee.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 07/04/23
 */
class MovieViewModel(
    private val useCase: GetMoviePopularUseCase
): ViewModel() {

    private val _observeMovieState: MutableStateFlow<MovieState> = MutableStateFlow(MovieState())
    val observeMovieState: StateFlow<MovieState> = _observeMovieState

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            useCase.invoke().collect { result ->
                when(result) {
                    is Resource.Error -> {
                        _observeMovieState.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = result.errorMessage
                            )
                        }
                    }
                    is Resource.Success -> {
                        val data = result.model
                        _observeMovieState.update {
                            it.copy(
                                movies = data?.results,
                                isLoading = false,
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeMovieState.update {
                            it.copy(
                                isLoading = true,
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

}