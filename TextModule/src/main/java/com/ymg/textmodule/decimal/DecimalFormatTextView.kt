package com.ymg.textmodule.decimal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R



class DecimalFormatTextView : AppCompatTextView {

    // Text 앞에 붙일 텍스트, Text 뒤에 붙일 텍스트
    private var addTextStart: String = ""
    private var addTextEnd: String = ""

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
                R.styleable.DecimalFormatTextStyle,
                defStyleAttr,
                defStyleAttr
            )


        // 텍스트 앞에 추가할 텍스트
        val addTextStart =
            typedArray?.getString(
                R.styleable.DecimalFormatTextStyle_dfAddTextStart
            )

        // 텍스트 뒤에 추가할 텍스트
        val addTextEnd =
            typedArray?.getString(
                R.styleable.DecimalFormatTextStyle_dfAddTextEnd
            )

        // 소수 끝에 0 제거 여부
        val isStripZero =
            typedArray?.getBoolean(
                R.styleable.DecimalFormatTextStyle_dfIsStripZero,
                true
            )

        typedArray?.recycle()

        setInit(
            addTextStart = addTextStart ?: "",
            addTextEnd = addTextEnd ?: "",
            isStripZero = isStripZero ?: true,
        )
    }



    /**
     * 설정
     */
    private fun setInit(
        addTextStart: String = "",
        addTextEnd: String = "",
        isStripZero: Boolean = true
    ) {
        setFormatText(this.text.toString(), addTextStart, addTextEnd, isStripZero)
    }



    /**
     * 값 설정
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String = "",
        addTextStart: String = this.addTextStart,
        addTextEnd: String = this.addTextEnd,
        isStripZero: Boolean = this.isStripZero
    ) {
        this.addTextStart = addTextStart
        this.addTextEnd = addTextEnd
        this.isStripZero = isStripZero


        val value = text.replace("[^[-]?\\d.]".toRegex(), "")

        if (value.isNotEmpty()) {
            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaFormat(value, isStripZero)}$addTextEnd"
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