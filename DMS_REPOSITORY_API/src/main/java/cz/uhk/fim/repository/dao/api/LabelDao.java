package cz.uhk.fim.repository.dao.api;

import cz.uhk.fim.repository.entity.Label;
import java.util.List;

public interface LabelDao {
        
    /**
     * 
     * @param id
     * @return 
     */
    Label getLabelById(Long id);
    
    /**
     * 
     * @param name
     * @return 
     */
    Label getLabelByName(String name);
    
    /**
     * 
     * @param labelName
     * @return 
     */
    Label addNewLabel(String labelName);
    
    List<Label> getAllLabels();
}
