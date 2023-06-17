package com.rajnish.presonalstudy.printer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.rajnish.presonalstudy.MainActivity

class PrinterConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {


        if (Intent.ACTION_POWER_CONNECTED == intent.action){

            val launchIntent = Intent(context, MainActivity::class.java)
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(launchIntent)


            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
            Log.d("Tag","Connected")
        }
        if (Intent.ACTION_POWER_DISCONNECTED == intent.action){

            val launchIntent = Intent(context, MainActivity::class.java)
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(launchIntent)

            Toast.makeText(context, "Diconnected", Toast.LENGTH_SHORT).show()
            Log.d("Tag","disconnected")
        }

    }
}
