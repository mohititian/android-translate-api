# Introduction #

Add your content here.


# Details #

To use in your android activity:

  * Get your locale
> > `Locale curLocale = this.getResources().getConfiguration().locale;`

  * Set up your translation instance
> > `I18nTranslator i18nTranslator = new I18nTranslator(curLocale .getLanguage());`

  * Translate your String auto-magically
> > `String text = i18nTranslator.translateString("Please enter correct keys to unlock.");`

  * Translate your Android Resource String auto-magically
> > `String text = i18nTranslator.translateString(getString(R.string.menu_feedback);`