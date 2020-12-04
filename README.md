# TextModule
<img width="250px" height="500px" src="/sample/sample.png" />
<br/>
<br/>



## 1. NumberFormatTextView

> 이것은 정수를 천 단위일 때마다 ","로 분리하는 TextView입니다.
> This is a TextView that separates the integer into "," every thousand units.

### XML Attributes

```xml
<com.ymg.textmodule.number.NumberFormatTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="5000"
    app:nfAddTextStart="Point: "
    app:nfAddTextEnd="P" />
```
- app:nfAddTextStart
    - 맨 앞에 문자열을 추가한다.
    - Add a string to the beginning.

- app:nfAddTextEnd
    - 맨 뒤에 문자열을 추가한다.
    - Add a string at the end.


### Kotlin Function

```kotlin

/**
 - 정수를 천 단위일 때마다 ","로 분리한다.
 - Separate an integer with "," every thousand units.
 */
fun setFormatText(
    text: String,
    addTextStart: String,
    addTextEnd: String
)

/**
 - 오직 정수 값을 가져온다.
 - Only take a integer value.
 */
fun getFormatText()
```
<br/>
<br/>



## 2. DecimalFormatTextView

-이것은 소수를 천 단위일 때마다 ","로 분리하는 TextView입니다.

-This is a TextView that separates the decimal number into "," every thousand units.

### XML Attributes

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| dfAddTextStart | 맨 앞에 문자열을 추가한다. | Add a string to the beginning. |
| dfAddTextEnd | 맨 뒤에 문자열을 추가한다. | Add a string at the end. |
| dfIsStripZero | 소수 끝에 0을 제거한다. | Remove zero at the end of the decimal point. |

### Kotlin Function

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;addTextStart: String,<br/>&nbsp;&nbsp;&nbsp;addTextEnd: String,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리한다. | Separate the decimal number with "," every thousand units. |
| getFormatText() | 오직 소수 값을 가져온다. | Only take a decimal value. |
<br/>
<br/>



## 3. DecimalFormatUpTextView

-이것은 소수를 천 단위일 때마다 ","로 분리하고 반올림하는 TextView입니다.

-This is a TextView that separates and rounds the decimal number to "," every thousand units.

### XML Attributes

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| dfuAddTextStart | 맨 앞에 문자열을 추가한다. | Add a string to the beginning. |
| dfuAddTextEnd | 맨 뒤에 문자열을 추가한다. | Add a string at the end. |
| dfuCutLength | 반올림 자릿수이다. | It's a rounding digit. |
| dfuIsStripZero | 소수 끝에 0을 제거한다. | Remove zero at the end of the decimal point. |

### Kotlin Function

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;addTextStart: String,<br/>&nbsp;&nbsp;&nbsp;addTextEnd: String,<br/>&nbsp;&nbsp;&nbsp;cutLength: Int,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리하고 반올림한다. | Separate the decimal number with "," and round it up every thousand units. |
| getFormatText() | 오직 소수 값을 가져온다. | Only take a decimal value. |
<br/>
<br/>



## 4. DecimalFormatDownTextView

-이것은 소수를 천 단위일 때마다 ","로 분리하고 버림하는 TextView입니다.

-This is a TextView that separates the decimal number into "," every thousand units and throws it away.

### XML Attributes

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| dfdAddTextStart | 맨 앞에 문자열을 추가한다. | Add a string to the beginning. |
| dfdAddTextEnd | 맨 뒤에 문자열을 추가한다. | Add a string at the end. |
| dfdCutLength | 버림 자릿수이다. | It's an abandoned digit. |
| dfdIsStripZero | 소수 끝에 0을 제거한다. | Remove zero at the end of the decimal point. |

### Kotlin Function

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;addTextStart: String,<br/>&nbsp;&nbsp;&nbsp;addTextEnd: String,<br/>&nbsp;&nbsp;&nbsp;cutLength: Int,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리하고 버림한다. | Separate and discard the decimal number with "," every thousand units. |
| getFormatText() | 오직 소수 값을 가져온다. | Only take a decimal value. |
<br/>
<br/>



## 5. NumberFormatUtil

-이것은 정수를 천 단위일 때마다 ","로 분리하는 Object 클래스입니다.

-This is an Object Class that separates an integer into "," every thousand units.

### Kotlin Function

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| getNumberCommaFormat(<br/>&nbsp;&nbsp;&nbsp;text: String<br/>) | 정수를 천 단위일 때마다 ","로 분리한다. | Separate an integer with "," every thousand units. |
<br/>
<br/>



## 6. DecimalFormatUtil

-이것은 소수를 천 단위일 때마다 ","로 분리하는 Object 클래스입니다.

-This is an Object Class that separates an decimal into "," every thousand units.

### Kotlin Function

| Name | Description(KO) | Description(EN) |
|:----------|:-------|:-------|
| getDecimalCommaFormat(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리한다. | Separate the decimal number with "," every thousand units. |
| getDecimalCommaUpFormat(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;length: Int,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리하고 반올림한다. | Separate the decimal number with "," and round it up every thousand units. |
| getDecimalCommaDownFormat(<br/>&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;length: Int,<br/>&nbsp;&nbsp;&nbsp;isStripZero: Boolean<br/>) | 소수를 천 단위일 때마다 ","로 분리하고 버림한다. | Separate and discard the decimal number with "," every thousand units. |
<br/>
<br/>


