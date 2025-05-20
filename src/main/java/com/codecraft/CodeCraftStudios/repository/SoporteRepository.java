package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Soporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SoporteRepository {

    private List<Soporte> listaSoporte = new ArrayList<>();

    public List<Soporte> obtenerSoportes() {
        return listaSoporte;
    }

    public Soporte buscarPorId(int id) {
        for (Soporte soporte : listaSoporte) {
            if (soporte.getId() == id) {
                return soporte;
            }
        }
        return null;
    }

    public Soporte guardar(Soporte soporte) {
        listaSoporte.add(soporte);
        return soporte;
    }

    public Soporte actualizar(Soporte soporte) {
        int id = soporte.getId();
        for (int i = 0; i < listaSoporte.size(); i++) {
            if (listaSoporte.get(i).getId() == id) {
                Soporte actualizado = new Soporte();
                actualizado.setId(id);
                actualizado.setNombre(soporte.getNombre());
                actualizado.setEmail(soporte.getEmail());
                actualizado.setEspecialidad(soporte.getEspecialidad());
                actualizado.setDisponibilidad(soporte.getDisponibilidad());
                actualizado.setTelefono(soporte.getTelefono());
                actualizado.setObservaciones(soporte.getObservaciones());
                listaSoporte.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Soporte soporte = buscarPorId(id);
        if (soporte != null) {
            listaSoporte.remove(soporte);
        }
    }
}
