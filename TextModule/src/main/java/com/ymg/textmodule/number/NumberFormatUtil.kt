package com.ymg.textmodule.number

import java.text.NumberFormat



object NumberFormatUtil {

    /**
     * , 로 구분
     */
    fun getNumberCommaFormat(text: String): String {
        val value = text.replace("[^\\d]".toRegex(), "")

        return if (value.isNotEmpty()) {
            val formatter = NumberFormat.getNumberInstance()
            val number = formatter.format(value.toBigDecimal())
            number
        } else {
            ""
        }
    }
}