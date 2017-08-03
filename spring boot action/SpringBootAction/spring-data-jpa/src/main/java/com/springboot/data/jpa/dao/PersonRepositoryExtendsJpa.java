package com.springboot.data.jpa.dao;

import com.springboot.data.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yukai on 2017/8/1.
 */
public interface PersonRepositoryExtendsJpa extends JpaRepository<Person,Long>{

    List<Person> findByName(String name);

    Person getByAge(int age);

    List readByNameAndAge(String name ,int age);

    @Query("select p from Person p where address=:address and age=:age")
    List<Person> selectOfCustomBindByName(@Param("address")String address, @Param("age")int age);

    @Query("select p from Person p where id=?1 and age=?2")
    List<Person> selectOfCustomBindByNumber(long id,int age);
}
