package com.ps.composemultiplatformplayground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform