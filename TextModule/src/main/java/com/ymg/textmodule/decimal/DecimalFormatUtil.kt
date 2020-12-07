package com.ymg.textmodule.decimal

import android.util.Log
import java.lang.Exception
import java.math.RoundingMode
import java.text.NumberFormat



/**
 * @author y-mg
 *
 * 이것은 소수를 천 단위일 때마다 "," 로 분리하는 Object 클래스입니다.
 * This is an Object Class that separates an decimal into "," every thousand units.
 */
object DecimalFormatUtil {

    /**
     * - 정수를 천 단위일 때마다 "," 로 분리한다.
     * - Separate an integer with "," every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param isStripZero -> Zero Removal Status
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
     * - 소수를 천 단위일 때마다 "," 로 분리하고 반올림한다.
     * - Separate the decimal number with "," and round it up every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param length -> Rounding digit
     *
     * @param isStripZero -> Zero Removal Status
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
     * - 소수를 천 단위일 때마다 "," 로 분리하고 버림한다.
     * - Separate and discard the decimal number with "," every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param length -> Abandoned digit
     *
     * @param isStripZero -> Zero Removal Status
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