package fungjai.intern.bosstanayot.internfungjaikotlin.musicList

import retrofit2.Call
import retrofit2.http.GET

interface MusicListApi {
    @GET("/musiclist")
    fun getMusicList(): Call<List<MusicListData>>
}