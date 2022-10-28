package com.eazyschool.repository;

import java.util.List;

import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.eazyschool.model.Courses;

@Repository
//@RepositoryRestResource(path="courses")
@RepositoryRestResource(exported=false)
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
	  List<Courses>findByOrderByNameDesc();
	
	
	 List<Courses> findByOrderByName();
}
