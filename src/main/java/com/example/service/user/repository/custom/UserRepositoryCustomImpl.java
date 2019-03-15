package com.example.service.user.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.service.user.model.User;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	@Autowired
	EntityManager em;
	
	@Override
	public List<User> getUsersByNameOrCity(String name, String city) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq= cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		Predicate namePredicate = cb.equal(user.get("name"), name);
		Predicate cityPredicate = cb.equal(user.get("address"), city);
		if(name != null && city != null)
			cq.where(cityPredicate, namePredicate);
		else if(name != null && city == null)
			cq.where(namePredicate);
		else if(name == null && city != null)
			cq.where(cityPredicate);
		TypedQuery<User> query = em.createQuery(cq);
		return query.getResultList();
	}

}
