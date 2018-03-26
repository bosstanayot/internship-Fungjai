package fungjai.intern.bosstanayot.internfungjaikotlin.MusicList

import retrofit2.Call
import retrofit2.http.GET

interface MusicListApi {
    @GET("/musiclist")
    fun getMusicList(): Call<List<MusicListData>>
}