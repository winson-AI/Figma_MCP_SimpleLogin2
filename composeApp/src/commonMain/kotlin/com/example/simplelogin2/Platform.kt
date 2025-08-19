package com.example.simplelogin2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform