package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Calificacion;
@Repository
public class CalificacionDaoImpl implements ICalificacionDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Calificacion> list() {
        return em.createQuery("from Calificacion").getResultList();
    }

    @Override
    public void save(Calificacion calificacion) {
        if(calificacion.getId() != null && calificacion.getId() >0){
            em.merge(calificacion);
        }else{
            em.persist(calificacion);
        }
    }

    @Override
    public Calificacion getById(Long id) {
        return em.find(Calificacion.class, id);
    }

    @Override
    public void delete(Long id) {
        Calificacion calificacion = getById(id);
        em.remove(calificacion);
    }

    
}
