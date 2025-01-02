package com.app.tones

import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hk1089.tones.AlarmClass
import com.hk1089.tones.NotificationClass
import com.hk1089.tones.RingClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onNotification(view: View) {
        val context = view.context
        val notifications = NotificationClass().getAllSystemNotificationTones(this)
        val titles = notifications.map { it.first }.toTypedArray() // Extract titles
        var currentRingtone: Ringtone? = null

        AlertDialog.Builder(context)
            .setTitle("Select Notification Tone")
            .setItems(titles) { dialog, which ->
                val selectedTone = notifications[which]
                val title = selectedTone.first
                val uri = selectedTone.second

                // Stop any currently playing ringtone
                currentRingtone?.stop()

                // Play the selected ringtone
                currentRingtone = RingtoneManager.getRingtone(context, uri)
                currentRingtone?.play()

                Toast.makeText(context, "Playing: $title", Toast.LENGTH_SHORT).show()
            }
            .setOnDismissListener {
                // Stop ringtone when dialog is dismissed
                currentRingtone?.stop()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Stop ringtone if playing
                currentRingtone?.stop()
                dialog.dismiss()
            }
            .show()
    }

    fun onRingtone(view: View) {
        val ringtones = RingClass().getAllSystemRingtones(this)
        ringtones.forEach { (title, uri) ->
            println("Title: $title, URI: $uri")
        }
    }
    fun onAlarm(view: View) {
        val alarms = AlarmClass().getAllSystemAlarmTones(this)
        alarms.forEach { (title, uri) ->
            println("Title: $title, URI: $uri")
        }
    }

    fun onDefaultAlarm(view: View) {
        val defaultAlarmUri = AlarmClass().getDefaultAlarmUri(this)
        println("Default Alarm URI: $defaultAlarmUri")
    }
    fun onDefaultNotification(view: View) {
        val defaultNotificationUri = NotificationClass().getDefaultNotificationUri(this)
        println("Default Notification URI: $defaultNotificationUri")
    }
    fun onDefaultRingtone(view: View) {
        val defaultRingtoneUri = RingClass().getDefaultRingtoneUri(this)
        println("Default Ringtone URI: $defaultRingtoneUri")

    }

}