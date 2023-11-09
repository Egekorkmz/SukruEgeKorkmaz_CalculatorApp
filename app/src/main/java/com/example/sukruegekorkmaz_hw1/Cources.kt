package com.example.sukruegekorkmaz_hw1

class Cources {

    private var code: String? = null
    private var imgId = 0

    constructor(name: String?, imgId: Int) {
        this.code = name
        this.imgId = imgId
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(name: String?) {
        this.code = name
    }

    fun getImgId(): Int {
        return imgId
    }

    fun setImgId(imgId: Int) {
        this.imgId = imgId
    }

}