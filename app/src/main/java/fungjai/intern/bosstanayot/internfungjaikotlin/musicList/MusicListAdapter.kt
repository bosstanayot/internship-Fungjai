package fungjai.intern.bosstanayot.internfungjaikotlin.musicList

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import fungjai.intern.bosstanayot.internfungjaikotlin.R


class MusicListAdapter(var context: Context, var musicList: List<MusicListData>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var imageView: ImageView
    lateinit var progressBar: ProgressBar

    class ZineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zineTitle: TextView = itemView.findViewById(R.id.zine_title)
        val description: TextView = itemView.findViewById(R.id.description)
        val cover: ImageView = itemView.findViewById(R.id.zine_cover)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressbar)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    class TrackHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val song: TextView = itemView.findViewById(R.id.song)
        val artist: TextView = itemView.findViewById(R.id.artist)
        val cover: ImageView = itemView.findViewById(R.id.track_cover)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressbar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val inflater: View = LayoutInflater.from(parent.context).inflate(R.layout.track_item, null, false)
                TrackHolder(inflater)
            }
            else -> {
                val inflater: View = LayoutInflater.from(parent.context).inflate(R.layout.zine_item, null, false)
                ZineHolder(inflater)
            }
        }
    }

    override fun getItemCount(): Int {
        return musicList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val trackHolder = holder as TrackHolder
                imageView = trackHolder.cover
                progressBar = trackHolder.progressBar

                trackHolder.artist.text = musicList?.get(position)?.artist
                trackHolder.song.text = musicList?.get(position)?.song
                setImgFromUrl(musicList?.get(position)?.cover, progressBar, imageView)
            }
            1 -> {
                val zineHolder = holder as ZineHolder
                imageView = zineHolder.cover
                progressBar = zineHolder.progressBar

                zineHolder.zineTitle.text = musicList?.get(position)?.title
                zineHolder.description.text = musicList?.get(position)?.description
                setImgFromUrl(musicList?.get(position)?.cover, progressBar, imageView)

                zineHolder.cardView.setOnClickListener {
                    openBrowserWithUrl(musicList?.get(position)?.url)
                }
            }
        }
    }

    private fun openBrowserWithUrl(url: String?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(browserIntent)
    }

    override fun getItemViewType(position: Int): Int {
        return when (musicList?.get(position)?.type) {
            "track" -> 0
            else -> 1
        }
    }

    private fun setImgFromUrl(imgUrl: String?, progressBarHolder: ProgressBar, imgView: ImageView) {
        Glide.with(context)
                .load(imgUrl)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        progressBarHolder.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        progressBarHolder.visibility = View.GONE
                        return false
                    }

                })
                .apply(RequestOptions().error(R.drawable.error_img))
                .into(imgView)
    }

}