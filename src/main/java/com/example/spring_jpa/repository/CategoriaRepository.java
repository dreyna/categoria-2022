
package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
