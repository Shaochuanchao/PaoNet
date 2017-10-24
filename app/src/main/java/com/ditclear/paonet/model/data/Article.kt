package com.ditclear.paonet.model.data

import com.ditclear.paonet.model.data.callback.DiffItemCallBack
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * 页面描述：文章
 *
 * Created by ditclear on 2017/9/26.
 */

class Article(var title: String?) : DiffItemCallBack<Article>, Serializable, Slider {
    var id: Int = 0
    var user: User? = null
    var content: String? = null
    var readme: String? = null
    @SerializedName("describe")
    var description: String? = null
    var click: Int = 0
    var channel: Int = 0
    var comments: Int = 0
    var stow: Int = 0
    var upvote: Int = 0
    var downvote: Int = 0
    var url: String? = null
    var pubDate: String? = null
    var thumbnail: String? = null

    ///////////////////////bind view////////////////////////


    override fun getSliderThumbnail(): String? = thumbnail

    override fun getSliderTitle(): String? = title


    override fun areItemsTheSame(newItem: Article): Boolean =
            Objects.equals(id, newItem.id) && Objects.equals(title, newItem.title)

    override fun areContentsTheSame(newItem: Article) = Objects.equals(content, newItem.content) && Objects.equals(click, newItem.click)


    /**
     * @return as 2 days ago · 20 reads
     */
    fun getDateAndClicks() = String.format("%s  ·  %d reads", pubDate, click)

    fun getCodeDateAndClicks() = String.format("%d查看  %d收藏\t%s", click, stow, pubDate)
}