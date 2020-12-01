# TextModule
<img width="250px" height="500px" src="/sample/sample.png" />
<br/>
<br/>



## 1. NumberFormatTextView

### XML

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| nfAddTextStart | null | 앞에 추가할 문자열 | String to add initially |
| nfAddTextEnd | null | 뒤에 추가할 문자열 | String to add to end |

### Kotlin

| Function | Parameter | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String? = "",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextStart: String? = this.addTextStart,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextEnd: String? = this.addTextEnd<br/>) | Number,<br/>Start String,<br/>End String | 숫자 Formatting | Number formatting |
| getFormatText() | Void | 숫자 값 가져오기 | Get only number |
<br/>
<br/>



## 2. DecimalFormatTextView

### XML

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| dfAddTextStart | null | 앞에 추가할 문자열 | String to add initially |
| dfAddTextEnd | null | 뒤에 추가할 문자열 | String to add to end |

### Kotlin

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String? = "",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextStart: String? = this.addTextStart,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextEnd: String? = this.addTextEnd,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Start String,<br/>End String,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
| getFormatText() | Void | 소수 값 가져오기 | Get only decimal |
<br/>
<br/>



## 3. DecimalFormatUpTextView

### XML

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| dfuAddTextStart | null | 앞에 추가할 문자열 | String to add initially |
| dfuAddTextEnd | null | 뒤에 추가할 문자열 | String to add end |
| dfuCutLength | 8 | 소수점 반올림 자릿수 | Rounding digits |

### Kotlin

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String? = "",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;up: Int = this.cutLength,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextStart: String? = this.addTextStart,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextEnd: String? = this.addTextEnd,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Digits,<br/>Start String,<br/>End String,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
| getFormatText() | Void | 소수 값 가져오기 | Get only decimal |
<br/>
<br/>



## 4. DecimalFormatDownTextView

### XML

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| dfdAddTextStart | null | 앞에 추가할 문자열 | String to add initially |
| dfdAddTextEnd | null | 뒤에 추가할 문자열 | String to add end |
| dfdCutLength | 8 | 소수점 내림 자릿수 | Cutting digits |

### Kotlin

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| setFormatText(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String? = "",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;down: Int = this.cutLength,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextStart: String? = this.addTextStart,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;addTextEnd: String? = this.addTextEnd,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Digits,<br/>Start String,<br/>End String,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
| getFormatText() | Void | 소수 값 가져오기 | Get only Decimal |
<br/>
<br/>



## 5. NumberFormatUtil

### Kotlin

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| getNumberCommaFormat(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String<br/>) | Number | 숫자 Formatting | Number formatting |
<br/>
<br/>



## 6. DecimalFormatUtil

### Kotlin

| Option | Default | Description(KO) | Description(EN) |
|:----------|:----------|:----------|:----------|
| getDecimalCommaFormat(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
| getDecimalCommaUpFormat(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;length: Int,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Digits,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
| getDecimalCommaDownFormat(<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text: String,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;length: Int,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;isStripZero: Boolean = true<br/>) | Decimal,<br/>Digits,<br/>Strip Zero | 소수 Formatting | Decimal formatting |
<br/>
<br/>


