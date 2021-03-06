package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Category;


@Repository // Nesse caso, essa anotação é opcional, porque esta herdando da classe JPARepository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}
