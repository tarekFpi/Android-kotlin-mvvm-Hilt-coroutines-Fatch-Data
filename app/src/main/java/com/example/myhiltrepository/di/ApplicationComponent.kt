package com.example.myhiltrepository.di

import com.example.myhiltrepository.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

 fun inject(mainActivity: MainActivity)

}