package fungjai.intern.bosstanayot.internfungjaikotlin.MusicList

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
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


class MusicListAdapter(var context: Context, var musicList: List<MusicListData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    class ZineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val zineTitle = itemView.findViewById(R.id.zine_title) as TextView
        val description = itemView.findViewById(R.id.description) as TextView
        val cover = itemView.findViewById(R.id.zine_cover) as ImageView
        val progressBar = itemView.findViewById(R.id.progressbar) as ProgressBar
    }

    class TrackHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val song = itemView.findViewById(R.id.song) as TextView
        val artist = itemView.findViewById(R.id.artist) as TextView
        val cover = itemView.findViewById(R.id.track_cover) as ImageView
        val progressBar = itemView.findViewById(R.id.progressbar) as ProgressBar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val inflater: View = LayoutInflater.from(parent.context).inflate(R.layout.track_item, null, false)
                val trackHolder = TrackHolder(inflater)
                return trackHolder
            }
            else -> {
                val inflater: View = LayoutInflater.from(parent.context).inflate(R.layout.zine_item, null, false)
                val zineHolder = ZineHolder(inflater)
                return zineHolder
            }
        }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val trackHolder: TrackHolder = holder as TrackHolder
                imageView = trackHolder.cover
                progressBar = trackHolder.progressBar

                trackHolder.artist.setText(musicList.get(position).artist)
                trackHolder.song.setText(musicList.get(position).song)
                setImgFromUrl(musicList.get(position).cover, progressBar, imageView)
            }
            1 -> {
                val zineHolder: ZineHolder = holder as ZineHolder
                imageView = zineHolder.cover
                progressBar = zineHolder.progressBar

                zineHolder.zineTitle.setText(musicList.get(position).title)
                zineHolder.description.setText(musicList.get(position).description)
                setImgFromUrl(musicList.get(position).cover, progressBar, imageView)

                imageView.setOnClickListener {
                    openBrowserWithUrl(musicList.get(position).url)
                }
                zineHolder.zineTitle.setOnClickListener {
                    openBrowserWithUrl(musicList.get(position).url)
                }
            }
        }
    }

    fun openBrowserWithUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(browserIntent)
    }

    override fun getItemViewType(position: Int): Int {
        when (musicList.get(position).type) {
            "track" -> return 0
            else -> return 1
        }
    }

    fun setImgFromUrl(imgUrl: String, progressBarHolder: ProgressBar, imgView: ImageView) {
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