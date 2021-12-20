package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;


@Repository
@Transactional
public class CustomRepositoryImp<T> implements CustomRepository{
	@Autowired
	EntityManager em;
	
	@Override
	public Customer save(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Page<Customer> getInfo(Pageable pageable) {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
			Root<Customer> r = cq.from(Customer.class);
			cq.select(r);
			List<Customer> result = null;
			TypedQuery<Customer> typedQuery=em.createQuery(cq);
			typedQuery.setFirstResult((int) pageable.getOffset());
			typedQuery.setMaxResults(pageable.getPageSize());
			result=typedQuery.getResultList();
			int count=em.createQuery(cq).getResultList().size();
			Page<Customer> page = new PageImpl<Customer>(result, pageable, count);
			return page;
	}
	/*
	 * @Override public Page<Customer> getInfoWithPagination(int pageNumber, int
	 * pageSize) { CriteriaBuilder cb = em.getCriteriaBuilder();
	 * CriteriaQuery<Customer> cq = cb.createQuery(Customer.class); Root<Customer>
	 * root = cq.from(Customer.class); cq.select(root);
	 * 
	 * TypedQuery<Customer> typedQuery = em.createQuery(cq);
	 * typedQuery.setFirstResult(pageNumber-1); typedQuery.setMaxResults(pageSize);
	 * List<Customer> list = typedQuery.getResultList(); Page<Customer> page = new
	 * PageImpl<Customer>(list); return page;
	 * 
	 * }
	 */
	/*
	 * @Override public T update(T object, Class<T> clazz){
	 * 
	 * em.merge(object); return object; }
	 */
	@Override
	public void  updategetImageid(int id,String imageid) {
		 CriteriaBuilder cb= em.getCriteriaBuilder();
	  CriteriaUpdate<Customer> criteriaUpdate = cb.createCriteriaUpdate(Customer.class);
	    Root<Customer> employeeRoot = criteriaUpdate.from(Customer.class);
	    criteriaUpdate.set(employeeRoot.get("imageid"),imageid).where(cb.equal(employeeRoot.get("id"),id));
	    em.createQuery(criteriaUpdate).executeUpdate();
	}
	
	@Override
	public Customer getId(int id){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Customer> critQuery = criteriaBuilder.createQuery(Customer.class);
	    Root<Customer> rootMovie = critQuery.from(Customer.class);
	    critQuery.where(criteriaBuilder.equal(rootMovie.get("id"),id));
	    Customer res= em.createQuery(critQuery).getSingleResult();
		return res;
		
		
	}
	
}
