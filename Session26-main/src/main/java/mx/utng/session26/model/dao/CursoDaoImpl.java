package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Curso;



@Repository
public class CursoDaoImpl implements ICursoDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Curso> list() {
        return em.createQuery("from Curso").getResultList();
    }

    @Override
    public void save(Curso curso) {
        if(curso.getId() != null && curso.getId() >0){
            em.merge(curso);
        }else{
            em.persist(curso);
        }
    }

    @Override
    public Curso getById(Long id) {
        return em.find(Curso.class, id);
    }

    @Override
    public void delete(Long id) {
        Curso teacher = getById(id);
        em.remove(teacher);
    }

    
}
