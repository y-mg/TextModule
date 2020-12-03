package com.ymg.textmodule.decimal

import android.util.Log
import java.lang.Exception
import java.math.RoundingMode
import java.text.NumberFormat



object DecimalFormatUtil {

    /**
     * , 로 구분
     */
    fun getDecimalCommaFormat(text: String, isStripZero: Boolean = true): String {
        val value = when (isStripZero) {
            true -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .stripTrailingZeros()
                    .toPlainString()
            }

            false -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .toPlainString()
            }
        }

        return try {
            when {
                value.contains(".") -> {
                    val number = value.substring(0, value.indexOf("."))
                    val decimal = value.substring(value.indexOf("."))

                    val formatter = NumberFormat.getNumberInstance()
                    "${formatter.format(number.toBigDecimal())}${decimal}"
                }

                else -> {
                    val formatter = NumberFormat.getNumberInstance()
                    formatter.format(value)
                }
            }
        } catch (e: Exception) {
            Log.e("ERROR!!!", e.message.toString())
            return ""
        }
    }



    /**
     * , 로 구분 + 소수점 반올림
     */
    fun getDecimalCommaUpFormat(text: String, length: Int, isStripZero: Boolean = true): String {
        val value = when (isStripZero) {
            true -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .setScale(length, RoundingMode.CEILING)
                    .stripTrailingZeros()
                    .toPlainString()
            }

            false -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .toPlainString()
            }
        }

        return try {
            when {
                value.contains(".") -> {
                    val number = value.substring(0, value.indexOf("."))
                    val decimal = value.substring(value.indexOf("."))

                    val formatter = NumberFormat.getNumberInstance()
                    "${formatter.format(number.toBigDecimal())}${decimal}"
                }

                else -> {
                    val formatter = NumberFormat.getNumberInstance()
                    formatter.format(value)
                }
            }
        } catch (e: Exception) {
            Log.e("ERROR!!!", e.message.toString())
            return ""
        }
    }



    /**
     * , 로 구분 + 소수점 내림
     */
    fun getDecimalCommaDownFormat(text: String, length: Int, isStripZero: Boolean = true): String {
        val value = when (isStripZero) {
            true -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .setScale(length, RoundingMode.FLOOR)
                    .stripTrailingZeros()
                    .toPlainString()
            }

            false -> {
                text.replace("[^[-]?\\d.]".toRegex(), "")
                    .toBigDecimal()
                    .toPlainString()
            }
        }

        return try {
            when {
                value.contains(".") -> {
                    val number = value.substring(0, value.indexOf("."))
                    val decimal = value.substring(value.indexOf("."))

                    val formatter = NumberFormat.getNumberInstance()
                    "${formatter.format(number.toBigDecimal())}${decimal}"
                }

                else -> {
                    val formatter = NumberFormat.getNumberInstance()
                    formatter.format(value)
                }
            }
        } catch (e: Exception) {
            Log.e("ERROR!!!", e.message.toString())
            return ""
        }
    }
}