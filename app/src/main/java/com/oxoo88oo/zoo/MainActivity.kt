package com.oxoo88oo.zoo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mSp: Spinner? = null
    private var mLv: ListView? = null
    private var mImg: ImageView? = null

    lateinit var mAdpBirds: ArrayAdapter<*>
    lateinit var mAdpFishes: ArrayAdapter<*>
    lateinit var mAdpReptiles: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSp = findViewById(R.id.spinner) as Spinner
        mLv = findViewById(R.id.list_item) as ListView
        mImg = findViewById(R.id.image) as ImageView



        mAdpBirds = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.Birds))

        mAdpFishes = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.Fishes))

        mAdpReptiles = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.Reptiles))

        mSp!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                when (mSp!!.selectedItem.toString()) {
                    "Birds" -> mLv!!.adapter = mAdpBirds
                    "Fishes" -> mLv!!.adapter = mAdpFishes
                    "Reptiles" -> mLv!!.adapter = mAdpReptiles
                    else -> Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }

        mLv!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            mImg!!.setImageResource(resources.getIdentifier("com.oxoo88oo.zoo:drawable/a" +
                    mSp!!.selectedItemPosition + i, null, null))
        }
    }
}
