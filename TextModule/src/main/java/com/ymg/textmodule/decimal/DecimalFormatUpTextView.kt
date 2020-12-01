package com.ymg.textmodule.decimal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R


class DecimalFormatUpTextView : AppCompatTextView {

    // Text 앞에 붙일 텍스트, Text 뒤에 붙일 텍스트
    private var addTextStart: String = ""
    private var addTextEnd: String = ""

    // 소수점 반올림 자릿수
    private var cutLength: Int = 8



    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }


    private fun init(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        val typedArray =
            context.theme?.obtainStyledAttributes(
                attrs,
                R.styleable.DecimalFormatUpTextStyle,
                defStyleAttr,
                defStyleAttr
            )


        // 텍스트 앞에 추가할 텍스트
        val addTextStart =
            typedArray?.getString(
                R.styleable.DecimalFormatUpTextStyle_dfuAddTextStart
            )

        // 텍스트 뒤에 추가할 텍스트
        val addTextEnd =
            typedArray?.getString(
                R.styleable.DecimalFormatUpTextStyle_dfuAddTextEnd
            )

        // 소수점 반올림 길이
        val cutLength =
            typedArray?.getInt(
                R.styleable.DecimalFormatUpTextStyle_dfuCutLength,
                8
            )

        typedArray?.recycle()


        setInit(addTextStart, addTextEnd, cutLength)
    }



    /**
     * 설정
     */
    private fun setInit(
        addTextStart: String?,
        addTextEnd: String?,
        cutLength: Int?
    ) {
        addTextStart?.let {
            this.addTextStart = it
        }

        addTextEnd?.let {
            this.addTextEnd = it
        }

        cutLength?.let {
            this.cutLength = it
        }

        setFormatText(this.text.toString(), this.cutLength, this.addTextStart, this.addTextEnd, true)
    }



    /**
     * 값 설정
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String? = "",
        cutLength: Int = this.cutLength,
        addTextStart: String? = this.addTextStart,
        addTextEnd: String? = this.addTextEnd,
        isStripZero: Boolean = true
    ) {
        this.cutLength = cutLength

        addTextStart?.let {
            this.addTextStart = it
        }
        addTextEnd?.let {
            this.addTextEnd = it
        }


        val formatText: String? = when {
            !text.isNullOrEmpty() -> {
                text
            }

            else -> {
                ""
            }
        }

        formatText?.let {
            when {
                it.isEmpty() -> {
                    when {
                        !addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart$addTextEnd"
                        }

                        !addTextStart.isNullOrEmpty() && addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart"
                        }

                        addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextEnd"
                        }

                        else -> {
                            this.text = ""
                        }
                    }
                }

                it.isNotEmpty() && it.last().toString() == "." -> {
                    when {
                        !addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaUpFormat(it.replace(".", ""), cutLength, isStripZero)}.$addTextEnd"
                        }

                        !addTextStart.isNullOrEmpty() && addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaUpFormat(it.replace(".", ""), cutLength, isStripZero)}."
                        }

                        addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "${DecimalFormatUtil.getDecimalCommaUpFormat(it.replace(".", ""), cutLength, isStripZero)}.$addTextEnd"
                        }

                        else -> {
                            this.text = "${DecimalFormatUtil.getDecimalCommaUpFormat(it.replace(".", ""), cutLength, isStripZero)}."
                        }
                    }
                }

                it.isNotEmpty() && it.last().toString() != "." -> {
                    when {
                        !addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaUpFormat(it, cutLength, isStripZero)}$addTextEnd"
                        }

                        !addTextStart.isNullOrEmpty() && addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaUpFormat(it, cutLength, isStripZero)}"
                        }

                        addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "${DecimalFormatUtil.getDecimalCommaUpFormat(it, cutLength, isStripZero)}$addTextEnd"
                        }

                        else -> {
                            this.text = DecimalFormatUtil.getDecimalCommaUpFormat(it, cutLength, isStripZero)
                        }
                    }
                }
            }
        }
    }



    /**
     * 값 가져오기
     */
    fun getFormatText(): String {
        return this.text.toString()
            .replace(",", "")
            .replace(addTextStart, "")
            .replace(addTextEnd, "")
            .trim()
    }
}