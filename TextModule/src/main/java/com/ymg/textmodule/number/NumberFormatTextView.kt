package com.ymg.textmodule.number

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R



class NumberFormatTextView : AppCompatTextView {

    // Text 앞에 붙일 텍스트, Text 뒤에 붙일 텍스트
    private var addTextStart: String = ""
    private var addTextEnd: String = ""



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
                R.styleable.NumberFormatTextStyle,
                defStyleAttr,
                defStyleAttr
            )


        // 텍스트 앞에 추가할 텍스트
        val addTextStart =
            typedArray?.getString(
                R.styleable.NumberFormatTextStyle_nfAddTextStart
            )

        // 텍스트 뒤에 추가할 텍스트
        val addTextEnd =
            typedArray?.getString(
                R.styleable.NumberFormatTextStyle_nfAddTextEnd
            )

        typedArray?.recycle()


        setInit(addTextStart, addTextEnd)
    }



    /**
     * 설정
     */
    private fun setInit(
        addTextStart: String?,
        addTextEnd: String?
    ) {
        addTextStart?.let {
            this.addTextStart = it
        }

        addTextEnd?.let {
            this.addTextEnd = it
        }

        setFormatText(this.text.toString(), this.addTextStart, this.addTextEnd)
    }



    /**
     * 값 설정
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String? = "",
        addTextStart: String? = this.addTextStart,
        addTextEnd: String? = this.addTextEnd
    ) {
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

                it.isNotEmpty() -> {
                    when {
                        !addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${NumberFormatUtil.getNumberCommaFormat(it)}$addTextEnd"
                        }

                        !addTextStart.isNullOrEmpty() && addTextEnd.isNullOrEmpty() -> {
                            this.text = "$addTextStart${NumberFormatUtil.getNumberCommaFormat(it)}"
                        }

                        addTextStart.isNullOrEmpty() && !addTextEnd.isNullOrEmpty() -> {
                            this.text = "${NumberFormatUtil.getNumberCommaFormat(it)}$addTextEnd"
                        }

                        else -> {
                            this.text = NumberFormatUtil.getNumberCommaFormat(it)
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