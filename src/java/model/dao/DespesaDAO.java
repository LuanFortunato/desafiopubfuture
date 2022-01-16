package model.dao;

import javax.enterprise.context.Dependent;
import model.entity.Despesa;

@Dependent
public class DespesaDAO extends BaseDAO<Despesa>{
    
    public Despesa getById(Integer id)
    {
        return getEntityManager().find(Despesa.class, id);
    }
}
