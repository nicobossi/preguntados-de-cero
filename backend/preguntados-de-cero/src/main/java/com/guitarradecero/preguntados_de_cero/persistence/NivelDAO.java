package com.guitarradecero.preguntados_de_cero.persistence;

import com.guitarradecero.preguntados_de_cero.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelDAO extends JpaRepository<Nivel, Long> {

}
