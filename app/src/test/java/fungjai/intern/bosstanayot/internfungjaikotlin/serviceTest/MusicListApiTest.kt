package fungjai.intern.bosstanayot.internfungjaikotlin.serviceTest

import fungjai.intern.bosstanayot.internfungjaikotlin.musicList.MusicListApi
import fungjai.intern.bosstanayot.internfungjaikotlin.musicList.MusicListData
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MusicListApiTest {
    lateinit var musicListApi: MusicListApi
    lateinit var server: MockWebServer

    @Before
    @Throws(Exception::class)
    fun startServer() {
        server = MockWebServer()
        server.start()
        musicListApi = RestServiceTestHelper()
                .createRetrofitService(server.url("/").toString(), MusicListApi::class.java)
    }

    @Test
    @Throws(Exception::class)
    fun testLoadMusicList_ShouldNotNull() {
        server.enqueue(MockResponse().setResponseCode(200).setBody("[{\"artist\":\"ORNLY YOU\"}]"))
        val actual: Response<List<MusicListData>> = musicListApi.getMusicList().execute()


        Assert.assertNotNull(actual.body())
        Assert.assertEquals(200, actual.code())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun testLoadMusicList_ShouldNull() {
        server.enqueue(MockResponse().setResponseCode(404).setBody("[{\"artist\":\"ORNLY YOU\"}]"))
        val actual: Response<List<MusicListData>> = musicListApi.getMusicList().execute()

        Assert.assertNull(actual.body())
        Assert.assertEquals(404, actual.code().toLong())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun NotImplementedTest_ShouldNull() {
        server.enqueue(MockResponse().setResponseCode(501).setBody("[{\"artist\":\"ORNLY YOU\"}]"))
        val actual: Response<List<MusicListData>> = musicListApi.getMusicList().execute()

        Assert.assertNull(actual.body())
        Assert.assertEquals(501, actual.code().toLong())
    }

    @After
    @Throws(java.lang.Exception::class)
    fun stopServer() {
        server.shutdown()
    }

}