package com.springboot.data.jpa.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

import static com.springboot.data.jpa.specs.CustomerSpecs.byAuto;

public class CustomRepositoryImpl <T, ID extends Serializable> 
					extends SimpleJpaRepository<T, ID> implements CustomRepository<T,ID> {
	
	private final EntityManager entityManager;
	//父类没有不带参数的构造方法，这里手动构造父类
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	//通过EntityManager来完成查询
	@Override
	public Page<T> findByAuto(T example, Pageable pageable) {
		return findAll(byAuto(entityManager, example),pageable);
	}

	@Override
	public List selectBySql(String sql) {
		Query query=entityManager.createNativeQuery(sql);
		return query.getResultList();
	}

	@Override
	public List selectByHql(String hql) {
		Query query=entityManager.createQuery(hql);
		return query.getResultList();
	}
}
