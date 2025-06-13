package com.example.myweather.di

import com.example.myweather.data.WeatherRepositoryImpl
import com.example.myweather.domain.WeatherRepository
import com.example.myweather.screen.WeatherScreen
import com.example.myweather.viewmodel.WeatherStatesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl()}
    viewModel { WeatherStatesViewModel(get()) }
}