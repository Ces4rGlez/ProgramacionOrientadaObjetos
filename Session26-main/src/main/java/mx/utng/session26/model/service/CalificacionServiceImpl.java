package mx.utng.session26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import mx.utng.session26.model.dao.ICalificacionDao;
import mx.utng.session26.model.entity.Calificacion;


/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class CalificacionServiceImpl implements ICalificacionService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    public ICalificacionDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Calificacion> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Calificacion calificacion) {
        dao.save(calificacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Calificacion getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
  
   
}
