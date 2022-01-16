package model.dao;

import javax.enterprise.context.Dependent;
import model.entity.Receita;

@Dependent
public class ReceitaDAO extends BaseDAO<Receita> {
   
    public Receita getById(Integer id)
    {
        return getEntityManager().find(Receita.class, id);
    }
}
