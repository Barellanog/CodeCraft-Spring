package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Soporte;
import com.codecraft.CodeCraftStudios.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoporteService {

    @Autowired
    private SoporteRepository soporteRepository;

    public List<Soporte> getSoportes() {
        return soporteRepository.obtenerSoportes();
    }

    public Soporte saveSoporte(Soporte soporte) {
        return soporteRepository.guardar(soporte);
    }

    public Soporte getSoporteId(int id) {
        return soporteRepository.buscarPorId(id);
    }

    public Soporte updateSoporte(Soporte soporte) {
        return soporteRepository.actualizar(soporte);
    }

    public String deleteSoporte(int id) {
        soporteRepository.eliminar(id);
        return "Soporte eliminado";
    }
}
