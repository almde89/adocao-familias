package br.co.familias.operation;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * {@link DayTradeSecurityExchange} Specification. This defines the User Day Trade Operation by its
 * committed values and fields.
 *
 * @see SecurityExchangeOperation
 * @see DayTradeSecurityExchange
 */
public class DayTradeSpecification implements OperationSpecification {
  private @NotNull LocalDate operationDate;
  private @NotNull Asset operationAsset;

  /**
   * The recorded operation date.
   *
   * @param date operation date
   * @return this Specification for configuration.
   */
  public DayTradeSpecification operationDate(final LocalDate date) {
    operationDate = date;
    return this;
  }

  @Override
  public LocalDate operationDate() {
    return operationDate;
  }

  @Override
  public Asset operationAsset() {
    return operationAsset;
  }

  @Override
  public boolean validate(SecurityExchangeOperation operation) {
    return operation.getClass().isAssignableFrom(DayTradeSecurityExchange.class);
  }

  /**
   * Sets the {@link Asset} traded.
   * @param asset traded
   * @return this Specification for configuration.
   */
  public DayTradeSpecification asset(Asset asset) {
    operationAsset = asset;
    return this;
  }
}
