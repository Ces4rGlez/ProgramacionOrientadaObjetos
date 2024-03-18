package mx.utng.session26.model.service;


import java.util.List;

import mx.utng.session26.model.entity.Curso;

public interface ICursoService {
    List<Curso> list();
    void save(Curso curso);
    Curso getById(Long id);
    void delete(Long id);
}
