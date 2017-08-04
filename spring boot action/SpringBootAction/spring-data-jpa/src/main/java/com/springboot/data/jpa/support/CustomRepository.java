package com.springboot.data.jpa.support;

import com.springboot.data.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

//该接口不会创建这个接口的实例
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {
	
	Page<T> findByAuto(T example, Pageable pageable);

	List selectBySql(String sql);

	List selectByHql(String sql);


}
