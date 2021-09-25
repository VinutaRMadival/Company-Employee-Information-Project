package com.vco.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.project.model.DepartmentDTO;

@Repository                  // as "a mechanism for encapsulating storage,
                          //retrieval, and search behavior which emulates a collection of objects".
public interface DepartmentRepository extends JpaRepository<DepartmentDTO,Integer>  {

	

}
