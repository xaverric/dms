package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.Label;
import java.util.List;

public interface LabelService {

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

    /**
     *
     * @return
     */
    List<Label> getAllLabels();

}
