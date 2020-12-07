package com.ymg.textmodule.decimal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R



/**
 * @author y-mg
 *
 * 이것은 소수를 천 단위일 때마다 "," 로 분리하고 버림하는 TextView 입니다.
 * This is a TextView that separates the decimal number into "," every thousand units and throws it away.
 */
class DecimalFormatDownTextView : AppCompatTextView {

    private var addTextStart: String = ""
    private var addTextEnd: String = ""
    private var cutLength: Int = 8
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
                R.styleable.DecimalFormatDownTextStyle,
                defStyleAttr,
                defStyleAttr
            )

        // 맨 앞에 문자열을 추가한다.
        // Add a string to the beginning.
        val addTextStart =
            typedArray?.getString(
                R.styleable.DecimalFormatDownTextStyle_dfdAddTextStart
            )

        // 맨 뒤에 문자열을 추가한다.
        // Add a string at the end.
        val addTextEnd =
            typedArray?.getString(
                R.styleable.DecimalFormatDownTextStyle_dfdAddTextEnd
            )

        // 버림 자릿수이다.
        // It's an abandoned digit.
        val cutLength =
            typedArray?.getInt(
                R.styleable.DecimalFormatDownTextStyle_dfdCutLength,
                8
            )

        // 소수 끝에 0을 제거한다.
        // Remove zero at the end of the decimal point.
        val isStripZero =
            typedArray?.getBoolean(
                R.styleable.DecimalFormatDownTextStyle_dfdIsStripZero,
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
     * Setting Init
     */
    private fun setInit(
        addTextStart: String,
        addTextEnd: String,
        cutLength: Int,
        isStripZero: Boolean
    ) {
        setFormatText(this.text.toString(), addTextStart, addTextEnd, cutLength, isStripZero)
    }



    /**
     * - 소수를 천 단위일 때마다 "," 로 분리하고 버림한다.
     * - Separate and discard the decimal number with "," every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param addTextStart -> Value to be added first
     *
     * @param addTextEnd -> Value to be added at the end
     *
     * @param cutLength -> Abandoned digit
     *
     * @param isStripZero -> Zero Removal Status
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String = this.text.toString(),
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
            this.text = "$addTextStart${DecimalFormatUtil.getDecimalCommaDownFormat(value, cutLength, isStripZero)}$addTextEnd"
        } else {
            this.text = "${addTextStart}${addTextEnd}"
        }
    }



    /**
     * - 오직 소수 값을 가져온다.
     * - Only take a decimal value.
     */
    fun getFormatText(): String {
        return this.text.toString().replace("[^[-]?\\d.]".toRegex(), "")
    }
}