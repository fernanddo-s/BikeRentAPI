package com.aluguelbicicleta.aluguelbicicleta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.model.Tranca;

public interface TrancaRepository extends JpaRepository<Tranca, Long>{
    
    List<Tranca> findTrancasByTotemId(Long totemId);

    @Query("select b from Bicicleta b \n" + //
            "inner join Tranca t on t.bicicleta.id =b.id \n" + //
            "where t.id = :trancaId")
    Bicicleta findBicicletaByTrancaId(@Param("trancaId")Long trancaId);
}
