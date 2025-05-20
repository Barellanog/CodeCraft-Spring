package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Administrador;
import com.codecraft.CodeCraftStudios.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAdministradores() {
        return administradorRepository.obtenerAdministradores();
    }

    public Administrador saveAdministrador(Administrador admin) {
        return administradorRepository.guardar(admin);
    }

    public Administrador getAdministradorId(int id) {
        return administradorRepository.buscarPorId(id);
    }

    public Administrador updateAdministrador(Administrador admin) {
        return administradorRepository.actualizar(admin);
    }

    public String deleteAdministrador(int id) {
        administradorRepository.eliminar(id);
        return "Administrador eliminado";
    }
}
