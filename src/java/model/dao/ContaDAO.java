package model.dao;

import javax.enterprise.context.Dependent;
import model.entity.Conta;

@Dependent
public class ContaDAO extends BaseDAO<Conta>  {
    
    public Conta getById(Integer id)
    {
        return getEntityManager().find(Conta.class, id);
    }
}
