package com.ymg.textmodule.number

import java.text.NumberFormat



/**
 * @author y-mg
 *
 * 이것은 정수를 천 단위일 때마다 "," 로 분리하는 Object 클래스입니다.
 * This is an Object Class that separates an integer into "," every thousand units.
 */
object NumberFormatUtil {

    /**
     * - 정수를 천 단위일 때마다 "," 로 분리한다.
     * - Separate an integer with "," every thousand units.
     *
     * @param text -> Value to Format
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