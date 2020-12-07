package com.ymg.textmodule.decimal

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R



/**
 * @author y-mg
 *
 * 이것은 소수를 천 단위일 때마다 "," 로 분리하는 TextView 입니다.
 * This is a TextView that separates the decimal number into "," every thousand units.
 */
class DecimalFormatTextView : AppCompatTextView {

    private var addTextStart: String = ""
    private var addTextEnd: String = ""
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

        // 맨 앞에 문자열을 추가한다.
        // Add a string to the beginning.
        val addTextStart =
            typedArray?.getString(
                R.styleable.DecimalFormatTextStyle_dfAddTextStart
            )

        // 맨 뒤에 문자열을 추가한다.
        // Add a string at the end.
        val addTextEnd =
            typedArray?.getString(
                R.styleable.DecimalFormatTextStyle_dfAddTextEnd
            )

        // 소수 끝에 0을 제거한다.
        // Remove zero at the end of the decimal point.
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
     * Init Setting
     */
    private fun setInit(
        addTextStart: String = "",
        addTextEnd: String = "",
        isStripZero: Boolean = true
    ) {
        setFormatText(this.text.toString(), addTextStart, addTextEnd, isStripZero)
    }



    /**
     * - 소수를 천 단위일 때마다 "," 로 분리한다.
     * - Separate the decimal number with "," every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param addTextStart -> Value to be added first
     *
     * @param addTextEnd -> Value to be added at the end
     *
     * @param isStripZero -> Zero Removal Status
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String = this.text.toString(),
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
     * - 오직 소수 값을 가져온다.
     * - Only take a decimal value.
     */
    fun getFormatText(): String {
        return this.text.toString().replace("[^[-]?\\d.]".toRegex(), "")
    }
}