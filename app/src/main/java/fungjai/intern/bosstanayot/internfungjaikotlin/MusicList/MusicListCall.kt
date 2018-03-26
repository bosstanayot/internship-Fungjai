package fungjai.intern.bosstanayot.internfungjaikotlin.MusicList

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MusicListCall (val applicationContext: Context, val recyclerView: RecyclerView, val progressDialog: ProgressDialog){

    fun createRetrofitService() {
         val client = OkHttpClient().newBuilder().build()
         val retrofit = Retrofit
                 .Builder()
                 .client(client)
                 .baseUrl("https://us-central1-fjawesomeintern.cloudfunctions.net")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
         val musicListApi: MusicListApi = retrofit.create(MusicListApi::class.java)

         callMusicList(musicListApi)
    }

    fun callMusicList(musicListApi: MusicListApi){
        val call: Call<List<MusicListData>> = musicListApi.getMusicList()
        call.enqueue(object : Callback<List<MusicListData>> {
            override fun onFailure(call: Call<List<MusicListData>>, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<MusicListData>>, response: Response<List<MusicListData>>) {
                if (response.isSuccessful) {
                    val musicListData: List<MusicListData> = response.body()!!

                    createRecycler(musicListData)
                    progressDialog.dismiss()
                }
            }

        })
    }

    fun createRecycler(musicListData: List<MusicListData>){
        val musicListAdapter = MusicListAdapter(applicationContext, musicListData)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = musicListAdapter
    }
}