package com.buap.roboapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var bluetoothAdapter: BluetoothAdapter? = null
    private var pairedDevices: Set<BluetoothDevice>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    }

    fun bluetoothOn(view: View) {
        if (!bluetoothAdapter!!.isEnabled) {
            val turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(turnOn, 0)
            Toast.makeText(applicationContext, "Turned on", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Already on", Toast.LENGTH_LONG).show()
        }
    }

    fun bluetoothOff(view: View) {
        bluetoothAdapter!!.disable()
        Toast.makeText(applicationContext, "Turned off" ,Toast.LENGTH_LONG).show()
    }

    fun visible(view: View) {
        val getVisible = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
        startActivityForResult(getVisible, 0)
    }

    fun list(view: View) {
        pairedDevices = bluetoothAdapter!!.bondedDevices

        val list = ArrayList<String>()

        pairedDevices!!.forEach { device -> list.add(device.name) }

        Toast.makeText(applicationContext, "Showing Paired Devices",Toast.LENGTH_SHORT).show()

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
    }
}
