package fungjai.intern.bosstanayot.internfungjaikotlin

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import fungjai.intern.bosstanayot.internfungjaikotlin.MusicList.MusicListCall

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        val progressDialog = ProgressDialog.show(this, "Dowload Data", "Loading...", true, false)
        MusicListCall(applicationContext, recyclerView, progressDialog).createRetrofitService()
    }

    private fun bindView() {
        recyclerView = findViewById(R.id.data_list) as RecyclerView
    }

}

