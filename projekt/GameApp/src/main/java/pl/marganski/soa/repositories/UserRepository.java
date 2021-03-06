package pl.marganski.soa.repositories;

import java.util.Optional;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.marganski.soa.jpa.entities.User;

@Singleton
@Startup
public class UserRepository {
	@PersistenceContext(unitName = "GameApp")
	private EntityManager entityManager;

	public Optional<User> findOneByUsername(String username) {
		try {
			Query query = entityManager.createNamedQuery("user.specificUserByName");
			query.setParameter("username", username);
			Object result = query.getSingleResult();
			return Optional.of((User) result);
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	public void update(User user) {
		entityManager.merge(user);
	}

	
}