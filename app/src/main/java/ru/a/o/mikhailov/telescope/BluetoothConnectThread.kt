package ru.a.o.mikhailov.telescope

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.IOException
import java.util.*

@SuppressLint("MissingPermission")
class BluetoothConnectThread(private val device: BluetoothDevice, context: Context): Thread() {

    private val uuid = "00001101-0000-1000-8000-00805F9B34FB"
    private var mSocket: BluetoothSocket? = null
    private val cnt = context




    init{
        try {
            mSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(uuid))

        }catch (i: IOException){

        }
    }

    override fun run() {
        try{
            Log.d("mylog", "try to connect...")
            ContextCompat.getMainExecutor(cnt).execute {
                Toast.makeText(cnt, "try to connect...", Toast.LENGTH_LONG).show()
            }
            mSocket?.connect()
            Log.d("mylog", "connected")
            ContextCompat.getMainExecutor(cnt).execute {
                Toast.makeText(cnt, "connected", Toast.LENGTH_LONG).show()
            }
        }catch (i: IOException){
            Log.d("mylog", "Can not connected to device")
            ContextCompat.getMainExecutor(cnt).execute {
                Toast.makeText(cnt, "Can not connected to device", Toast.LENGTH_LONG).show()
            }
            closeConnection()
        }
    }

    fun closeConnection(){
        try {
            mSocket?.close()
        }catch (i: IOException){

        }
    }
}