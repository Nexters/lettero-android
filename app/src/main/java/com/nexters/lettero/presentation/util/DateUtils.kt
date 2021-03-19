package com.nexters.lettero.presentation.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun toDatetime(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyyMMdd HH:mm:ss")
        return sdf.format(Date(timestamp))
    }

    fun toServerTimestamp(datetime: String): Long {
        val sdf = SimpleDateFormat("yyyyMMdd HH:mm:ss")
        return sdf.parse(datetime).time
    }
}
