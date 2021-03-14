package br.co.familias.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
  @PersistenceUnit(unitName = "model")
  EntityManager manager;

  @Produces
  @RequestScoped
  public EntityManager getModelEntityManager() {
    return manager;
  }
}
