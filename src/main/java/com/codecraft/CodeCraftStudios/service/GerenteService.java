package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Gerente;
import com.codecraft.CodeCraftStudios.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    public List<Gerente> getGerentes() {
        return gerenteRepository.obtenerGerentes();
    }

    public Gerente saveGerente(Gerente gerente) {
        return gerenteRepository.guardar(gerente);
    }

    public Gerente getGerenteId(int id) {
        return gerenteRepository.buscarPorId(id);
    }

    public Gerente updateGerente(Gerente gerente) {
        return gerenteRepository.actualizar(gerente);
    }

    public String deleteGerente(int id) {
        gerenteRepository.eliminar(id);
        return "Gerente eliminado";
    }
}