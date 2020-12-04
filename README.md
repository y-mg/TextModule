# TextModule
<img width="250px" height="500px" src="/sample/sample.png" />
<br/>
<br/>



## 1. NumberFormatTextView

> 이것은 정수를 천 단위일 때마다 ","로 분리하는 TextView입니다.<br/>
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
 * - 정수를 천 단위일 때마다 ","로 분리한다.
 * - Separate an integer with "," every thousand units.
 *
 * @param text -> Value to Format
 *
 * @param addTextStart -> Value to be added first
 *
 * @param addTextEnd -> Value to be added at the end
 */
fun setFormatText(
    text: String,
    addTextStart: String,
    addTextEnd: String
)

/**
 * - 오직 정수 값을 가져온다.
 * - Only take a integer value.
 */
fun getFormatText()
```
<br/>
<br/>



## 2. DecimalFormatTextView

> 이것은 소수를 천 단위일 때마다 ","로 분리하는 TextView입니다.<br/>
> This is a TextView that separates the decimal number into "," every thousand units.

### XML Attributes

```xml
<com.ymg.textmodule.decimal.DecimalFormatTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="1000.5555555555"
    app:dfAddTextStart="BitCoin: "
    app:dfAddTextEnd="BTC"
    app:dfIsStripZero="true" />
```
- app:dfAddTextStart
    - 맨 앞에 문자열을 추가한다.
    - Add a string to the beginning.

- app:dfAddTextEnd
    - 맨 뒤에 문자열을 추가한다.
    - Add a string at the end.

- app:dfIsStripZero
    - 소수 끝에 0을 제거한다.
    - Remove zero at the end of the decimal point.


### Kotlin Function

```kotlin
/**
 * - 소수를 천 단위일 때마다 ","로 분리한다.
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
fun setFormatText(
    text: String,
    addTextStart: String,
    addTextEnd: String,
    isStripZero: Boolean
)

/**
 * - 오직 소수 값을 가져온다.
 * - Only take a decimal value.
 */
fun getFormatText()
```
<br/>
<br/>



## 3. DecimalFormatUpTextView

> 이것은 소수를 천 단위일 때마다 ","로 분리하고 반올림하는 TextView입니다.<br/>
> This is a TextView that separates and rounds the decimal number to "," every thousand units.


### XML Attributes

```xml
<com.ymg.textmodule.decimal.DecimalFormatUpTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="1000.5555555555"
    app:dfuAddTextStart="USD: "
    app:dfuAddTextEnd="$"
    app:dfuCutLength="5"
    app:dfuIsStripZero="true" />
```
- app:dfuAddTextStart
    - 맨 앞에 문자열을 추가한다.
    - Add a string to the beginning.

- app:dfuAddTextEnd
    - 맨 뒤에 문자열을 추가한다.
    - Add a string at the end.

- app:dfuCutLength
    - 반올림 자릿수이다.
    - It's a rounding digit.

- app:dfuIsStripZero
    - 소수 끝에 0을 제거한다.
    - Remove zero at the end of the decimal point.


### Kotlin Function

```kotlin
/**
 * - 소수를 천 단위일 때마다 ","로 분리하고 반올림한다.
 * - Separate the decimal number with "," and round it up every thousand units.
 *
 * @param text -> Value to Format
 *
 * @param addTextStart -> Value to be added first
 *
 * @param addTextEnd -> Value to be added at the end
 *
 * @param cutLength -> Rounding digit
 *
 * @param isStripZero -> Zero Removal Status
 */
fun setFormatText(
    text: String,
    addTextStart: String,
    addTextEnd: String,
    cutLength: Int,
    isStripZero: Boolean
)

/**
 * - 오직 소수 값을 가져온다.
 * - Only take a decimal value.
 */
fun getFormatText()
```
<br/>
<br/>



## 4. DecimalFormatDownTextView

> 이것은 소수를 천 단위일 때마다 ","로 분리하고 버림하는 TextView입니다.<br/>
> This is a TextView that separates the decimal number into "," every thousand units and throws it away.


### XML Attributes

```xml
<com.ymg.textmodule.decimal.DecimalFormatDownTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="1000.5555555555"
    app:dfdAddTextStart="USD: "
    app:dfdAddTextEnd="$"
    app:dfdCutLength="5"
    app:dfdIsStripZero="true" />
```
- app:dfdAddTextStart
    - 맨 앞에 문자열을 추가한다.
    - Add a string to the beginning.

- app:dfdAddTextEnd
    - 맨 뒤에 문자열을 추가한다.
    - Add a string at the end.

- app:dfdCutLength
    - 버림 자릿수이다.
    - It's an abandoned digit.

- app:dfdIsStripZero
    - 소수 끝에 0을 제거한다.
    - Remove zero at the end of the decimal point.


### Kotlin Function

```kotlin
/**
 * - 소수를 천 단위일 때마다 ","로 분리하고 버림한다.
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
fun setFormatText(
    text: String,
    addTextStart: String,
    addTextEnd: String,
    cutLength: Int,
    isStripZero: Boolean
)

/**
 * - 오직 소수 값을 가져온다.
 * - Only take a decimal value.
 */
fun getFormatText()
```
<br/>
<br/>



## 5. NumberFormatUtil

> 이것은 정수를 천 단위일 때마다 ","로 분리하는 Object 클래스입니다.<br/>
> This is an Object Class that separates an integer into "," every thousand units.


### Kotlin Function

```kotlin
/**
 * - 정수를 천 단위일 때마다 ","로 분리한다.
 * - Separate an integer with "," every thousand units.
 *
 * @param text -> Valute to Format
 */
fun getNumberCommaFormat(text: String)
```
<br/>
<br/>



## 6. DecimalFormatUtil

> 이것은 소수를 천 단위일 때마다 ","로 분리하는 Object 클래스입니다.<br/>
> This is an Object Class that separates an decimal into "," every thousand units.


### Kotlin Function

```kotlin
/**
 * - 정수를 천 단위일 때마다 ","로 분리한다.
 * - Separate an integer with "," every thousand units.
 *
 * @param text -> Value to Format
 *
 * @param isStripZero -> Zero Removal Status
 */
fun getNumberCommaFormat(
    text: String,
    isStripZero: Boolean
)

/**
 * - 소수를 천 단위일 때마다 ","로 분리하고 반올림한다.
 * - Separate the decimal number with "," and round it up every thousand units.
 *
 * @param text -> Value to Format
 *
 * @param length -> Rounding digit
 *
 * @param isStripZero -> Zero Removal Status
 */
fun getDecimalCommaUpFormat(
    text: String,
    length: Int,
    isStripZero: Boolean
)

/**
 * - 소수를 천 단위일 때마다 ","로 분리하고 버림한다.
 * - Separate and discard the decimal number with "," every thousand units.
 *
 * @param text -> Value to Format
 *
 * @param length -> Abandoned digit
 *
 * @param isStripZero -> Zero Removal Status
 */
fun getDecimalCommaDownFormat(
    text: String,
    length: Int,
    isStripZero: Boolean
)
```
<br/>
<br/>


