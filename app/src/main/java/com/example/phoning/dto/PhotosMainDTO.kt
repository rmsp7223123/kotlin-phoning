package com.example.phoning.dto

import java.io.Serializable

class PhotosMainDTO(var imgRes: Int,var  name: String) : Serializable {
     var imgSubs: IntArray? = null
     var isState: BooleanArray? = null
     var imgLikes: IntArray? = null
    fun setIsState() {
        isState = BooleanArray(imgSubs!!.size)
    }

    fun getIsState() {

    }
}