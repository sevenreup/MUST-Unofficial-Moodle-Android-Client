package com.skybox.seven.edustat.util

import java.text.SimpleDateFormat
import java.util.*


object DateHelper {
    /**
     * Format the conversation date
     * @param epoch time returned by Moodle
     * This formats it to a whatsapp like formating
     */
    fun chatDateRelative(epoch: Int): String {
        val dateTime = Date(epoch.toLong() * 1000)
        return convertToRelative(dateTime)
    }

    fun convertToRelative(dateTime: Date): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = dateTime
        val today: Calendar = Calendar.getInstance()
        val yesterday: Calendar = Calendar.getInstance()
        yesterday.add(Calendar.DATE, -1)

        return if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(
                Calendar.DAY_OF_YEAR
            )
        ) {
            SimpleDateFormat("hh:mma").format(dateTime)
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(
                Calendar.DAY_OF_YEAR
            ) == yesterday.get(Calendar.DAY_OF_YEAR)
        ) {
            "Yesterday"
        } else {
            SimpleDateFormat("MM/dd/yyyy").format(dateTime)
        }
    }

    fun checkIfSameDate(now: Date, last: Date): Boolean {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = now
        val lastCal: Calendar = Calendar.getInstance()
        lastCal.time = last

        return (calendar.get(Calendar.YEAR) == lastCal.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == lastCal.get(
            Calendar.DAY_OF_YEAR
        ))
    }

    fun getTime(date: Date): String = SimpleDateFormat("hh:mma").format(date)
}