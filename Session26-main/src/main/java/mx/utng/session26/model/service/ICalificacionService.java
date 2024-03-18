package mx.utng.session26.model.service;

import java.util.List;

import mx.utng.session26.model.entity.Calificacion;


public interface ICalificacionService {
    List<Calificacion> list();
    void save(Calificacion calificacion);
    Calificacion getById(Long id);
    void delete(Long id);
}
