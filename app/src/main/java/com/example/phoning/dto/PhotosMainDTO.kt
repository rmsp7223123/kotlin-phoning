package com.example.phoning.dto

import java.io.Serializable

class PhotosMainDTO(imgRes: Int, name: String) : Serializable {
    private var imgRes: Int = imgRes
    private var name: String = name
    private var imgSubs: IntArray? = null
    private var isState: BooleanArray? = null

    fun setImgSubs(imgSubs: IntArray) {
        this.imgSubs = imgSubs
    }

    fun setIsState(isState: BooleanArray) {
        this.isState = isState
    }

    fun setIsState() {
        this.isState = BooleanArray(imgSubs?.size ?: 0)
    }
}