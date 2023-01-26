package com.example.spring_web_mvc.Repository;

import com.example.spring_web_mvc.Entities.Propertie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertieRepository extends PagingAndSortingRepository<Propertie, String> {

    @Query("Select c from Propertie c where c.name like %:filtro% order by category,subcategory,name")
    public List<Propertie> findByFiltro
            (@Param("filtro") String filtro);
}
