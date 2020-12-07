package com.ymg.textmodule.number

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ymg.textmodule.R



/**
 * @author y-mg
 *
 * 이것은 정수를 천 단위일 때마다 "," 로 분리하는 TextView 입니다.<br/>
 * This is a TextView that separates the integer into "," every thousand units.
 */
class NumberFormatTextView : AppCompatTextView {

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

        // 맨 앞에 문자열을 추가한다.
        // Add a string to the beginning.
        val addTextStart =
            typedArray?.getString(
                R.styleable.NumberFormatTextStyle_nfAddTextStart
            )

        // 맨 뒤에 문자열을 추가한다.
        // Add a string at the end.
        val addTextEnd =
            typedArray?.getString(
                R.styleable.NumberFormatTextStyle_nfAddTextEnd
            )

        typedArray?.recycle()


        setInit(
            addTextStart = addTextStart ?: "",
            addTextEnd = addTextEnd ?: "",
        )
    }



    /**
     * Init Setting
     */
    private fun setInit(
        addTextStart: String = "",
        addTextEnd: String = ""
    ) {
        setFormatText(this.text.toString(), addTextStart, addTextEnd)
    }



    /**
     * - 정수를 천 단위일 때마다 "," 로 분리한다.
     * - Separate an integer with "," every thousand units.
     *
     * @param text -> Value to Format
     *
     * @param addTextStart -> Value to be added first
     *
     * @param addTextEnd -> Value to be added at the end
     */
    @SuppressLint("SetTextI18n")
    fun setFormatText(
        text: String = this.text.toString(),
        addTextStart: String = this.addTextStart,
        addTextEnd: String = this.addTextEnd
    ) {
        this.addTextStart = addTextStart
        this.addTextEnd = addTextEnd


        val value = text.replace("[^\\d]".toRegex(), "")

        if (value.isNotEmpty()) {
            this.text = "${addTextStart}${NumberFormatUtil.getNumberCommaFormat(value)}${addTextEnd}"
        } else {
            this.text = "${addTextStart}${addTextEnd}"
        }
    }



    /**
     * - 오직 정수 값을 가져온다.
     * - Only take a integer value.
     */
    fun getFormatText(): String {
        return this.text.toString().replace("[^\\d]".toRegex(), "")

    }
}