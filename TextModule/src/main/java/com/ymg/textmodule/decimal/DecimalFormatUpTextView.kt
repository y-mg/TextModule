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

    // 소수 끝에 0 제거 여부
    private var isStripZero: Boolean = true



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

        // 소수 끝에 0 제거 여부
        val isStripZero =
            typedArray?.getBoolean(
                R.styleable.DecimalFormatUpTextStyle_dfuIsStripZero,
                true
            )

        typedArray?.recycle()


        setInit(
            addTextStart = addTextStart ?: "",
            addTextEnd = addTextEnd ?: "",
            cutLength = cutLength ?: 8,
            isStripZero = isStripZero ?: true
        )
    }



    /**
     * 설정
     */
    private fun setInit(
        addTextStart: String = "",
        addTextEnd: String = "",
        cutLength: Int = 8,
        isStripZero: Boolean = true
    ) {
        setFormatText(this.text.toString(), addTextStart, addTextEnd, cutLength, isStripZero)
    }



    /**
     * 값 설정
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String = "",
        addTextStart: String = this.addTextStart,
        addTextEnd: String = this.addTextEnd,
        cutLength: Int = this.cutLength,
        isStripZero: Boolean = this.isStripZero
    ) {
        this.addTextStart = addTextStart
        this.addTextEnd = addTextEnd
        this.cutLength = cutLength
        this.isStripZero = isStripZero


        val value = text.replace("[^[-]?\\d.]".toRegex(), "")

        if (value.isNotEmpty()) {
            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaUpFormat(value, cutLength, isStripZero)}$addTextEnd"
        } else {
            this.text = "${addTextStart}${addTextEnd}"
        }
    }



    /**
     * 값 가져오기
     */
    fun getFormatText(): String {
        return this.text.toString().replace("[^[-]?\\d.]".toRegex(), "")
    }
}