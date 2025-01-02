package com.hk1089.tones

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri

class NotificationClass {

    fun getAllSystemNotificationTones(context: Context): List<Pair<String, Uri>> {
        val notificationList = mutableListOf<Pair<String, Uri>>()
        val ringtoneManager = RingtoneManager(context)
        ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION) // Get notification

        val cursor = ringtoneManager.cursor
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
                val uri = ringtoneManager.getRingtoneUri(cursor.position)
                if (uri != null) {
                    notificationList.add(title to uri)
                }
            } while (cursor.moveToNext())
        }
        cursor?.close()

        return notificationList
    }

    fun getDefaultNotificationUri(context: Context): Uri {
        return RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_NOTIFICATION)
    }

}