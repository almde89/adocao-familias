package br.co.familias.infra;

import br.co.familias.*;
import br.co.familias.*;
import org.jboss.weld.junit5.auto.ActivateScopes;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.jboss.weld.junit5.auto.ExcludeBeanClasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@EnableAutoWeld
@ActivateScopes({RequestScoped.class, ApplicationScoped.class})
@AddPackages(OperationDAO.class)
@ExcludeBeanClasses({EntityManagerProducer.class})
class OperationDAOTest {
  @Produces
  @RequestScoped
  EntityManager manager = spy(Persistence.createEntityManagerFactory("test").createEntityManager());

  @Inject @Repository
  OperationDAO repo;

  @Test
  @DisplayName("Should Persist Operations")
  public void shouldPersisOperations() {
    final DayTradeSecurityExchange dayTrade = new DayTradeBuilder().create();

    final SecurityExchangeOperation persist = repo.persist(dayTrade);

    assertNotNull(repo);
    assertNotNull(repo.getManager());
    assertNotNull(persist);
    assertSame(dayTrade, persist);
    verify(manager).persist(eq(dayTrade));
  }
}
