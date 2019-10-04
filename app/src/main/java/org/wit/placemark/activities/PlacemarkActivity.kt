package org.wit.placemark.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_placemark.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.placemark.R
import org.wit.placemark.main.MainApp
import org.wit.placemark.models.PlacemarkModel


class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)
        app = application as MainApp

        btnAdd.setOnClickListener() {

            placemark.title = placemarkTitle.text.toString()
            placemark.desc = placemarkDesc.text.toString()

            if (placemark.title.isNotEmpty() && placemark.desc.isNotEmpty()) {
                app.placemarks.add(placemark.copy())
                for (i in app.placemarks.indices) {
                    info("Placemark[$i]:${this.app.placemarks[i]}")
                }
            }
            else {
                toast ("Please Enter a title and description")
            }
        }
    }
}

