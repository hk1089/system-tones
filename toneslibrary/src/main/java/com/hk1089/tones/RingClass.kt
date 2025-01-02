package com.hk1089.tones

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri

class RingClass {

    fun getAllSystemRingtones(context: Context): List<Pair<String, Uri>> {
        val ringtoneList = mutableListOf<Pair<String, Uri>>()
        val ringtoneManager = RingtoneManager(context)
        ringtoneManager.setType(RingtoneManager.TYPE_RINGTONE) // Get ringtones

        val cursor = ringtoneManager.cursor
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
                val uri = ringtoneManager.getRingtoneUri(cursor.position)
                if (uri != null) {
                    ringtoneList.add(title to uri)
                }
            } while (cursor.moveToNext())
        }
        cursor?.close()

        return ringtoneList
    }

    fun getDefaultRingtoneUri(context: Context): Uri {
        return RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_RINGTONE)
    }
}