package fungjai.intern.bosstanayot.internfungjaikotlin.modelTest

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fungjai.intern.bosstanayot.internfungjaikotlin.musicList.MusicListData
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.reflect.Type

class MusicListDataTest {
    private lateinit var json: String
    private lateinit var musicListData: List<MusicListData>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        json = TestHelper().getStringFromFile("musicList_api.json")
        var listType: Type = object : TypeToken<List<MusicListData>>() {}.type
        musicListData = Gson().fromJson<List<MusicListData>>(json, listType)
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex0_getArtist() {
        Assert.assertEquals("Artist", musicListData[0].artist, "ORNLY YOU")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex0_getCover() {
        Assert.assertEquals("Cover", musicListData[0].cover, "https://image.fungjai.com/2018/02/13/cover/1518527403434232.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex0_getSong() {
        Assert.assertEquals("Song", musicListData[0].song, "มะงึกๆอุ๋งๆ")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex0_getType() {
        Assert.assertEquals("Type", musicListData[0].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex1_getArtist() {
        Assert.assertEquals("Artist", musicListData[1].artist, "markmywords.")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex1_getCover() {
        Assert.assertEquals("Cover", musicListData[1].cover, "https://image.fungjai.com/2018/02/12/cover/1518429706726234.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex1_getSong() {
        Assert.assertEquals("Song", musicListData[1].song, "น้องสาวครับ (Sister)")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex1_getType() {
        Assert.assertEquals("Type", musicListData[1].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex2_getCover() {
        Assert.assertEquals("Cover", musicListData[2].cover, "https://www.fungjaizine.com/wp-content/uploads/2018/03/KAEW-TARWAAN-bnk48-fungjaizine-cover2.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex2_getDescription() {
        Assert.assertEquals("Artist", musicListData[2].description, "Fungjaizine ขอเชิญทุกท่านมาทำความรู้จัก แก้ว และ ตาหวาน 2" + " สมาชิกจากแก๊งชราไลน์แห่ง BNK48 กับเรื่องราวการไปเล่นดนตรีที่ญี่ปุ่นและชีวิตที่ทั้งคู่ไม่เคยเปิดเผยที่ไหนมาก่อน")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex2_getTitle() {
        Assert.assertEquals("Song", musicListData[2].title, "แก้วตาหวานใจ : Playlist เพลงโปรดของ แก้ว และ ตาหวาน BNK48")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex2_getType() {
        Assert.assertEquals("Type", musicListData[2].type, "zine")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex2_getUrl() {
        Assert.assertEquals("Url", musicListData[2].url, "https://www.fungjaizine.com/feature/my_ears/kaew-tawaan-bnk48")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex3_getArtist() {
        Assert.assertEquals("Artist", musicListData[3].artist, "markmywords.")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex3_getCover() {
        Assert.assertEquals("Cover", musicListData[3].cover, "https://image.fungjai.com/2018/01/22/cover/1516608278260238.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex3_getSong() {
        Assert.assertEquals("Song", musicListData[3].song, "แคปเฌอ (Capture)")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex3_getType() {
        Assert.assertEquals("Type", musicListData[3].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex4_getArtist() {
        Assert.assertEquals("Artist", musicListData[4].artist, "VWW")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex4_getCover() {
        Assert.assertEquals("Cover", musicListData[4].cover, "https://image.fungjai.com/2018/02/03/cover/1517676818626315.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex4_getSong() {
        Assert.assertEquals("Song", musicListData[4].song, "คุณพระอาทิตย์")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex4_getType() {
        Assert.assertEquals("Type", musicListData[4].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex5_getArtist() {
        Assert.assertEquals("Artist", musicListData[5].artist, "Meowhima")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex5_getCover() {
        Assert.assertEquals("Cover", musicListData[5].cover, "https://image.fungjai.com/2018/01/07/cover/1515336053305580.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex5_getSong() {
        Assert.assertEquals("Song", musicListData[5].song, "คนเกรี้ยวกราด")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex5_getType() {
        Assert.assertEquals("Type", musicListData[5].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex6_getArtist() {
        Assert.assertEquals("Artist", musicListData[6].artist, "Present to President")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex6_getCover() {
        Assert.assertEquals("Cover", musicListData[6].cover, "https://image.fungjai.com/2018/01/28/cover/1517116135510488.jpg")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex6_getSong() {
        Assert.assertEquals("Song", musicListData[6].song, "เพลงที่มีไม้ยมกเยอะๆ")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex6_getType() {
        Assert.assertEquals("Type", musicListData[6].type, "track")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex7_getCover() {
        Assert.assertEquals("Cover", musicListData[7].cover, "https://www.fungjaizine.com/wp-content/uploads/2017/10/cancanhead2.png")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex7_getDescription() {
        Assert.assertEquals("Artist", musicListData[7].description, "แคนแคน—นายิกา ศรีเนียน คือเด็กสาวน่ารัก อารมณ์ดี ด้วยภาพจำที่เธอเป็นหนึ่งในสมาชิก" + " BNK48 ไอดอลของมวลชน แต่ในอีกมุมหนึ่งเธอก็มีมิติของความเป็นผู้หญิงน่าค้นหา")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex7_getTitle() {
        Assert.assertEquals("Song", musicListData[7].title, "5 เพลงโปรดของ แคนแคน BNK48 และเหตุผลที่เธออยากเป็นนายกหญิงคนที่สอง!?")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex7_getType() {
        Assert.assertEquals("Type", musicListData[7].type, "zine")
    }

    @Test
    @Throws(Exception::class)
    fun parseJsonIndex7_getUrl() {
        Assert.assertEquals("Url", musicListData[7].url, "https://www.fungjaizine.com/feature/my_ears/cancan-bnk48")
    }

}