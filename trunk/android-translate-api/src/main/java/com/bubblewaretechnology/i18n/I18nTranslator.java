package com.bubblewaretechnology.i18n;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * Class to translate Strings to a device's locale.
 * 
 * @author David Gill
 *
 */
final public class I18nTranslator {
	//If you wrote your application's text in a different language, change it to that here
	private final static Language DEFAULTLANGUAGE = Language.ENGLISH;
	
	private final transient Language lToLanguage;
	
	/**
	 * Constructor so you can translate all text to a certain language after declaring.
	 * 
	 * @param toLanguage - the locale of the language to translate to 
	 * @author David Gill
	 */
	public I18nTranslator(final String toLanguage)
	{
		lToLanguage = Language.fromString(toLanguage);
		
		System.setProperty("http.proxyHost", "proxy");
		System.setProperty("http.proxyPort", "8080");
		
		//Enter your website here so google can contact you in case of problems.
		Translate.setHttpReferrer("http://bubblewaretechnology.com/"); 
	}

	/**
	 * Translates a string of text to whatever language was used in the constructor.
	 * 
	 * @param text - text to translate
	 * @return String - the translated text if it could be resolved
	 * @author David Gill
	 */
	@edu.umd.cs.findbugs.annotations.SuppressWarnings(value="DataflowAnomalyAnalysis", justification="Logic flow is bug free.")
	public String translateString(final String text)
	{
		String translatedText = "";
		
		if (lToLanguage.equals(DEFAULTLANGUAGE))
		{
			translatedText = text;
		}
		else
		{
			try {
				translatedText = Translate.execute(text, DEFAULTLANGUAGE, lToLanguage);
			} catch (Exception e) {
				//Just default to text in case of an exception, so at least they have something
				translatedText = text;
			}
		}

		return translatedText;
	}
}
