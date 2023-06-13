/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.readsensors.presentation

import android.content.Context
import android.hardware.SensorManager
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorEvent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.readsensors.R
import com.example.readsensors.presentation.theme.ReadSensorsTheme



class MainActivity : ComponentActivity() {

    //initializing accel variables
    private lateinit var accel_xAxis: TextView
    private lateinit var accel_yAxis: TextView
    private lateinit var accel_zAxis: TextView
    //initialaizing to read sensor values
    private lateinit var sensorManager: SensorManager

    //main code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
        setContentView(R.layout.activity_main)
        //link the accel values to the UI
        accel_xAxis = findViewById(R.id.xAxisTextView)
        accel_yAxis = findViewById(R.id.yAxisTextView)
        accel_zAxis = findViewById(R.id.zAxisTextView)
        //access the sensorManager service
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        //read accel values
        val sensorAccel: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val sensorEventListener: SensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(sensorEvent: SensorEvent) {
                //update and display read values to the Smartwatch UI
                accel_xAxis.setText("X-Axis: " + sensorEvent.values[0])
                accel_yAxis.setText("Y-Axis: " + sensorEvent.values[1])
                accel_zAxis.setText("Z-Axis: " +sensorEvent.values[2])
            }
            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
        }
        //parameters to read the accelerometer only in sensor manager
        sensorManager.registerListener(
            sensorEventListener,
            sensorAccel,
            SensorManager.SENSOR_DELAY_NORMAL
        )

    }










}


