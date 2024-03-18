package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.Calificacion;



public interface ICalificacionDao {
      List<Calificacion> list();
    void save(Calificacion calificacion);
    Calificacion getById(Long id);
    void delete(Long id);
}
