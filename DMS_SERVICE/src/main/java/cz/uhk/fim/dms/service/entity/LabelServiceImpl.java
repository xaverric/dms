package cz.uhk.fim.dms.service.entity;

import cz.uhk.fim.dms.service.api.entity.LabelService;
import cz.uhk.fim.repository.dao.api.LabelDao;
import cz.uhk.fim.repository.entity.Label;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService{

    @Autowired
    private LabelDao labelDao;
    
    @Override
    public Label addNewLabel(String labelName) {
       return labelDao.addNewLabel(labelName);
    }

    @Override
    public List<Label> getAllLabels() {
        return labelDao.getAllLabels();
    }

    @Override
    public Label getLabelById(Long id) {
        return labelDao.getLabelById(id);
    }

    @Override
    public Label getLabelByName(String name) {
        return labelDao.getLabelByName(name);
    }
    
}
