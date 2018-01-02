package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.FileDao;
import cz.uhk.fim.repository.dto.api.FileDTO;
import cz.uhk.fim.repository.entity.File;
import java.util.Calendar;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FileDaoImpl extends AbstractGenericDAO<File> implements FileDao {

    @Override
    public File addFile(FileDTO fileDto) {
        File file = new File();
        setDefaultParams(file);
        getEntityManager().persist(file);
        return file;
    }

    @Override
    public File deleteFileVersion(FileDTO fileDto, Long version) {
        return null;
    }

    @Override
    public File getFileByID(Long id) {
        return getEntityManager().find(File.class, id);
    }

    @Override
    public File getFileByNameUsername(String fileName, String username) {
        return null;
    }

    private void setDefaultParams(File file) {
        file.setLastModified(Calendar.getInstance().getTime());
        
    }

}
