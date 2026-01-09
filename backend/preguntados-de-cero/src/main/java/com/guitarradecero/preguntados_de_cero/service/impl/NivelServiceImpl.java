package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.Nivel;
import com.guitarradecero.preguntados_de_cero.persistence.NivelDAO;
import com.guitarradecero.preguntados_de_cero.service.NivelService;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
@Transactional
public class NivelServiceImpl implements NivelService {

    private NivelDAO nivelDAO;

    public NivelServiceImpl(NivelDAO dao){
        setNivelDAO(dao);
    }

    @Override
    public List<Nivel> getAll() {
        return getNivelDAO().findAll();
    }
}
