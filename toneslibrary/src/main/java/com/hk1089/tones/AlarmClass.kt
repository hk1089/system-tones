package com.hk1089.tones

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri

class AlarmClass {

    fun getAllSystemAlarmTones(context: Context): List<Pair<String, Uri>> {
        val alarmList = mutableListOf<Pair<String, Uri>>()
        val ringtoneManager = RingtoneManager(context)
        ringtoneManager.setType(RingtoneManager.TYPE_ALARM) // Get alarms

        val cursor = ringtoneManager.cursor
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
                val uri = ringtoneManager.getRingtoneUri(cursor.position)
                if (uri != null) {
                    alarmList.add(title to uri)
                }
            } while (cursor.moveToNext())
        }
        cursor?.close()

        return alarmList
    }

    fun getDefaultAlarmUri(context: Context): Uri {
        return RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_ALARM)
    }
}