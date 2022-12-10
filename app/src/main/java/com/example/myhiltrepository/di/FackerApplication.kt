package com.example.myhiltrepository.di

import android.app.Application

class FackerApplication :Application(){

    lateinit var applicationComponent: ApplicationComponent;

    override fun onCreate() {
        super.onCreate()

     // applicationComponent = DaggerApplicationComponent.builder().build()
    }
}