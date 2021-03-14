package br.co.familias.infra;

import org.jboss.weld.junit5.auto.ActivateScopes;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableAutoWeld
@ActivateScopes({RequestScoped.class, ApplicationScoped.class})
@AddPackages(OperationDAO.class)
public class EntityManagerTest {
  EntityManager manager = Persistence.createEntityManagerFactory("test").createEntityManager();

  @Test
  @DisplayName("Should Factory entity manager")
  public void shouldFactoryEntityManager() {
    assertNotNull(manager);
  }
}
