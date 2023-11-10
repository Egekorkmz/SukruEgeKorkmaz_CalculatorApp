package com.example.sukruegekorkmaz_hw1

import android.os.Parcel
import android.os.Parcelable

class Cources() :Parcelable{

    private var code: String? = null
    private var imgId = 0

    constructor(parcel: Parcel) : this() {
        code = parcel.readString()
        imgId = parcel.readInt()
    }

    constructor(name: String?, imgId: Int) : this() {
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeInt(imgId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cources> {
        override fun createFromParcel(parcel: Parcel): Cources {
            return Cources(parcel)
        }

        override fun newArray(size: Int): Array<Cources?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString() : String{
        return "Code : $code " +
                "||| Img : $imgId"
    }

}