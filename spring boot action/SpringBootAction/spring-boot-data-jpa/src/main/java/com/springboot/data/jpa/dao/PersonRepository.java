package com.springboot.data.jpa.dao;

import java.util.List;

import com.springboot.data.jpa.domain.Person;
import com.springboot.data.jpa.support.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//这个接口要实现有两个泛型参数，第一个T表示实体类，第二个表示主键的类型
public interface PersonRepository extends CustomRepository<Person, Long> {
	//在Spring Data JPA中提供了一种衍生查询，只要函数的声明有findBy,getBy,readBy,他就会去读取相应条件的数据
	//这些方法的返回值可以是一个列表，也可以是一个对象,spring Data JPA会自动根据返回类型来进行处理。我们不用写实现类
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name, String address);
	
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

	Person withNameAndAddressNamedQuery(String name, String address);

//	@Override
//	List selectByHql(String sql);
//
//	@Override
//	List selectBySql(String sql);
//
//	@Override
//	Page<Person> findByAuto(Person example, Pageable pageable);
}
