package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.Curso;



public interface ICursoDao {
    List<Curso> list();
    void save(Curso curso);
    Curso getById(Long id);
    void delete(Long id);
}
