package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Gerente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GerenteRepository {

    private List<Gerente> listaGerentes = new ArrayList<>();

    public List<Gerente> obtenerGerentes() {
        return listaGerentes;
    }

    public Gerente buscarPorId(int id) {
        for (Gerente gerente : listaGerentes) {
            if (gerente.getId() == id) {
                return gerente;
            }
        }
        return null;
    }

    public Gerente guardar(Gerente gerente) {
        listaGerentes.add(gerente);
        return gerente;
    }

    public Gerente actualizar(Gerente gerente) {
        int id = gerente.getId();
        for (int i = 0; i < listaGerentes.size(); i++) {
            if (listaGerentes.get(i).getId() == id) {
                Gerente actualizado = new Gerente();
                actualizado.setId(id);
                actualizado.setNombre(gerente.getNombre());
                actualizado.setEmail(gerente.getEmail());
                actualizado.setRol(gerente.getRol());
                actualizado.setCursosAsignados(gerente.getCursosAsignados());
                actualizado.setReportesGenerados(gerente.getReportesGenerados());
                listaGerentes.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Gerente gerente = buscarPorId(id);
        if (gerente != null) {
            listaGerentes.remove(gerente);
        }
    }
}