API to translate text on your android device to whatever language your Android device's locale is set to.

Uses google-api-translate-java (http://code.google.com/p/google-api-translate-java/).

**Quick Example**
```
Locale curLocale = this.getResources().getConfiguration().locale;
I18nTranslator i18nTranslator = new I18nTranslator(curLocale .getLanguage());

String text = i18nTranslator.translateString("YOUR-TEXT-HERE");
```