package br.co.familias;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Get Localized Message Exception.
 *
 * @see BrokerageNote.BrokerageNoteBuilder
 *
 */
public abstract class LocalizedMessageException extends RuntimeException {

  protected final String key;
  protected final Locale locale;
  protected final String[] parameters;

  /**
   * Uses de {@link Locale#getDefault()}.
   *
   * @param key exceptions.properties file key
   * @param parameters localized message parameters
   *
   */
  public LocalizedMessageException(final String key, final String... parameters) {
    this(key, Locale.getDefault(), parameters);
  }

  /**
   * User defined {@link Locale}.
   *
   * @param key exceptions.properties file key
   * @param locale {@link Locale} for te properties file
   *
   */
  public LocalizedMessageException(
      final String key, final Locale locale, final String... parameters) {
    this.key = key;
    this.locale = locale;
    this.parameters = parameters;
  }

  @Override
  public String getLocalizedMessage() {
    final String[] localizedParameters = new String[parameters.length];
    final ResourceBundle parameterBundle = ResourceBundle.getBundle("i18n", locale);
    final MessageFormat format =
        new MessageFormat(ResourceBundle.getBundle("exceptions", locale).getString(key), locale);

    for (int index = 0; index < parameters.length; ) {
      localizedParameters[index] = parameterBundle.getString(parameters[index++]);
    }

    return format.format(localizedParameters);
  }
}
