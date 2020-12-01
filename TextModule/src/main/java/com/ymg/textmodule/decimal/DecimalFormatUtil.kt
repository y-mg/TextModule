package com.ymg.textmodule.decimal

import java.math.RoundingMode
import java.text.NumberFormat



object DecimalFormatUtil {

    /**
     * , 로 구분
     */
    fun getDecimalCommaFormat(text: String, isStripZero: Boolean = true): String {
        val value = when(isStripZero) {
            true -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
                    .stripTrailingZeros()
            }

            false -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
            }
        }

        val strValue = value.toPlainString()

        when (isStripZero) {
            true -> {
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
                        val decimalResult = decimal.replace(".", "")

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
                            }
                        }
                    }

                    else -> {
                        val formatter = NumberFormat.getNumberInstance()
                        formatter.format(value)
                    }
                }
            }

            false -> {
                return when {
                    strValue.contains(".") -> {
                        val decimal = strValue.substring(strValue.lastIndexOf("."))
                        val number = strValue.replace(decimal, "")

                        val formatter = NumberFormat.getNumberInstance()

                        val numberResult = formatter.format(number.toBigDecimal())
                        val decimalResult = decimal.replace(".", "")

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
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
    }



    /**
     * , 로 구분 + 소수점 반올림
     */
    fun getDecimalCommaUpFormat(text: String, length: Int, isStripZero: Boolean = true): String {
        val value = when(isStripZero) {
            true -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
                    .setScale(length, RoundingMode.CEILING)
                    .stripTrailingZeros()
            }

            false -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
            }
        }

        val strValue = value.toPlainString()

        when (isStripZero) {
            true -> {
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
                        val decimalResult = decimal.replace(".", "")

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
                            }
                        }
                    }

                    else -> {
                        val formatter = NumberFormat.getNumberInstance()
                        formatter.format(value)
                    }
                }
            }

            false -> {
                return when {
                    strValue.contains(".") -> {
                        val decimal = strValue.substring(strValue.lastIndexOf("."))
                        val number = strValue.replace(decimal, "")

                        val formatter = NumberFormat.getNumberInstance()

                        val numberResult = formatter.format(number.toBigDecimal())
                        var decimalResult = decimal.replace(".", "")

                        if (decimalResult.length > length) {
                            decimalResult = "$numberResult.${decimalResult}".toBigDecimal().setScale(length, RoundingMode.CEILING).toPlainString().replace("$numberResult.", "")
                        }

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
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
    }



    /**
     * , 로 구분 + 소수점 내림
     */
    fun getDecimalCommaDownFormat(text: String, length: Int, isStripZero: Boolean = true): String {
        val value = when(isStripZero) {
            true -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
                    .setScale(length, RoundingMode.FLOOR)
                    .stripTrailingZeros()
            }

            false -> {
                text.replace(",", "")
                    .trim()
                    .toBigDecimal()
            }
        }

        val strValue = value.toPlainString()

        when (isStripZero) {
            true -> {
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
                        val decimalResult = decimal.replace(".", "")

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
                            }
                        }
                    }

                    else -> {
                        val formatter = NumberFormat.getNumberInstance()
                        formatter.format(value)
                    }
                }
            }

            false -> {
                return when {
                    strValue.contains(".") -> {
                        val decimal = strValue.substring(strValue.lastIndexOf("."))
                        val number = strValue.replace(decimal, "")

                        val formatter = NumberFormat.getNumberInstance()

                        val numberResult = formatter.format(number.toBigDecimal())
                        var decimalResult = decimal.replace(".", "")

                        if (decimalResult.length > length) {
                            decimalResult = "$numberResult.${decimalResult}".toBigDecimal().setScale(length, RoundingMode.FLOOR).toPlainString().replace("$numberResult.", "")
                        }

                        when {
                            number.contains("-0") -> {
                                "-$numberResult.$decimalResult"
                            }

                            else -> {
                                "$numberResult.$decimalResult"
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
    }
}