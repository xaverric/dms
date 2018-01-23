package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.LabelDao;
import cz.uhk.fim.repository.entity.Label;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LabelDaoImpl extends AbstractGenericDAO<Label> implements LabelDao{

    @Override
    public Label addNewLabel(String labelName) {
        Label label = getLabelByName(labelName);
        if(label == null){
            label = new Label();
            label.setName(labelName);
            getEntityManager().persist(label);
        }
        return label;
    }

    @Override
    public List<Label> getAllLabels() {
        return getEntityManager().createQuery("from Label", Label.class).getResultList();
    }

    @Override
    public Label getLabelById(Long id) {
    return getEntityManager().find(Label.class, id);
    }

    @Override
    public Label getLabelByName(String name) {
        Query query = getEntityManager().createQuery("from Label where name = :name", Label.class);
        query.setParameter("name", name);
        return getSingleResult(query);
    }
    
}
