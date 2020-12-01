package com.ymg.textmodule.number

import java.text.NumberFormat



object NumberFormatUtil {

    /**
     * , 로 구분
     */
    fun getNumberCommaFormat(text: String): String {
        val value = text
            .replace(",", "")
            .trim()
            .toBigDecimal()
            .stripTrailingZeros()

        val strValue = value.toPlainString()


        return when {
            strValue.toDouble() == 0.0 -> {
                val formatter = NumberFormat.getNumberInstance()
                formatter.format(value)
            }

            strValue.contains(".") -> {
                val decimal = strValue.substring(strValue.lastIndexOf("."))
                val number = strValue.replace(decimal, "")

                val formatter = NumberFormat.getNumberInstance()

                val numberResult = formatter.format(number.toBigDecimal())

                when {
                    number.contains("-0") -> {
                        "-$numberResult"
                    }

                    else -> {
                        numberResult
                    }
                }
            }

            else -> {
                val formatter = NumberFormat.getNumberInstance()
                formatter.format(value)
            }
        }
    }
}