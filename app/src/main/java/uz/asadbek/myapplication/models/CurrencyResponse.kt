package uz.asadbek.myapplication.models

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("code")
    val code: String,


    @SerializedName("Ccy")
    val currencyShortName: String,


    @SerializedName("CcyNm_RU")
    val currencyNameRU: String,


    @SerializedName("CcyNm_UZ")
    val currencyNameUZ: String,

    @SerializedName("CcyNm_UZC")
    val currencyNameUZC: String,

    @SerializedName("Nominal")
    val nominal: Int,

    @SerializedName("Rate")
    val course:Int,

    @SerializedName("Diff")
    val diff:String,

    @SerializedName("Date")
    val date: String

)