package com.example.phinconapp

import android.app.Application

class NoteApplication: Application() {
    lateinit var container: NoteContainer

    override fun onCreate() {
        super.onCreate()
        container = NoteContainer(this)
    }
}