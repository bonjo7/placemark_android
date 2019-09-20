package org.wit.placemark.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_placemark.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.placemark.R
import org.wit.placemark.models.PlacemarkModel


class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    val placemarks = ArrayList<PlacemarkModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)
        info("Placemark Activity started..")

        btnAdd.setOnClickListener() {
            placemark.title = placemarkTitle.text.toString()
            placemark.desc = placemarkDesc.text.toString()
            if (placemark.title.isNotEmpty()) {
                placemarks.add(placemark)
                info("Placemarks: $placemarks")

            }
            else {
                toast ("Please Enter a title")
            }
        }
    }
}

