package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class BaseDAO<T> {
    private EntityManager entityManager;
    
    public EntityManager getEntityManager(){
        if(entityManager == null){ 
            entityManager = Persistence.createEntityManagerFactory("DesafioPubFuturePU").createEntityManager();
        }
    
        return entityManager;
    }
    
    public T salvar(T objeto){
        
        try
        {
            getEntityManager().getTransaction().begin();
            objeto = getEntityManager().merge(objeto);
            getEntityManager().getTransaction().commit();
        }
        catch(Exception e)
        {   
            System.err.println("Erro: " +e.getLocalizedMessage());
            getEntityManager().getTransaction().rollback();
            return null;
        }
        
        return objeto;
        
    }
    
    public T remover(T objeto){
        
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(objeto);
            getEntityManager().getTransaction().commit();
        }
        catch(Exception e)
        {   
            System.err.println("Erro: " +e.getLocalizedMessage());
            getEntityManager().getTransaction().rollback();
            return null;
        }
        
        return objeto;
        
    }
    
    
    public List<T> recuperarTodosRegistros(String query){
        return getEntityManager().createNamedQuery(query).getResultList();
    }
}
