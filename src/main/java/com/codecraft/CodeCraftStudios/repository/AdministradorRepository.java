package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Administrador;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdministradorRepository {

    private List<Administrador> listaAdministradores = new ArrayList<>();

    public List<Administrador> obtenerAdministradores() {
        return listaAdministradores;
    }

    public Administrador buscarPorId(int id) {
        for (Administrador admin : listaAdministradores) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    public Administrador guardar(Administrador admin) {
        listaAdministradores.add(admin);
        return admin;
    }

    public Administrador actualizar(Administrador admin) {
        int id = admin.getId();
        for (int i = 0; i < listaAdministradores.size(); i++) {
            if (listaAdministradores.get(i).getId() == id) {
                Administrador actualizado = new Administrador();
                actualizado.setId(id);
                actualizado.setNombre(admin.getNombre());
                actualizado.setEmail(admin.getEmail());
                actualizado.setCargo(admin.getCargo());
                actualizado.setNivelAcceso(admin.getNivelAcceso());
                actualizado.setTelefono(admin.getTelefono());
                actualizado.setObservaciones(admin.getObservaciones());
                listaAdministradores.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Administrador admin = buscarPorId(id);
        if (admin != null) {
            listaAdministradores.remove(admin);
        }
    }
}
