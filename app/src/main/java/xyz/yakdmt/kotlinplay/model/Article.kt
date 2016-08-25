package xyz.yakdmt.kotlinplay.model

import android.net.Uri
import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName

/**
 * Created by yakdmt on 17/08/16.
 */
class Article constructor(@Nullable _name: String, @Nullable _imageUrl: String){

    @SerializedName("status")
    @Nullable
    val name = _name
    @SerializedName("time")
    @Nullable
    val imageUrl : Uri = Uri.parse(_imageUrl)

}