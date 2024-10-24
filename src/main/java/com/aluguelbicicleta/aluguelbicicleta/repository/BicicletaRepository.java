package com.aluguelbicicleta.aluguelbicicleta.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{
    
    @Query("select b from Bicicleta b \n" + 
            "inner join Tranca t on t.bicicleta.id = b.id\n" + 
            "where t.totem.id = :totemId")
    List<Bicicleta> findBicicletasByTotemId(@Param("totemId")Long totemId);
}
