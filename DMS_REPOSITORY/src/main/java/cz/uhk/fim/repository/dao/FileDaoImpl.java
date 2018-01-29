package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.FileDao;
import cz.uhk.fim.repository.dto.api.FileDTO;
import cz.uhk.fim.repository.entity.File;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

@Transactional
@Repository
public class FileDaoImpl extends AbstractGenericDAO<File> implements FileDao {

    @Override
    public File addFile(FileDTO fileDto) {
        File file = new File();
        setDefaultParams(file);
        setFileValues(file,fileDto);
        getEntityManager().persist(file);
        return file;
    }

    @Override
    public File deleteFileVersion(FileDTO fileDto, Long version) {
        if(fileDto == null){
            return null;
        }
        Query query = getEntityManager().createQuery("from File where name = :name and version = :version and dms_path = :dms_path", File.class);
        query.setParameter("name",fileDto.getName());
        query.setParameter("version", version);
        query.setParameter("dms_path", fileDto.getDmsPath());
        File file = getSingleResult(query);
        if (file != null) {
            getEntityManager().remove(file);
            return file;
        }
        return null;
    }

    @Override
    public List<File> findAllFiles() {
        return getEntityManager().createQuery("from File f where" +
            " f.version = (select max(f2.version) from File f2 where f.name= f2.name)", File.class).getResultList();
    }

    @Override
    public File getFileByID(Long id) {
        return getEntityManager().find(File.class, id);
    }

    @Override
    public File getFileByNameUsername(String fileName, String username) {
        Query query =  getEntityManager().createQuery("from File f where " +
            "f.name = :name and f.version = (select max(version) from File f2 where f2.name = f.name)");
        query.setParameter("name", fileName);

        return getSingleResult(query);
    }

    @Override
    public File getFileByUsername() {
        return null;
    }

    private void setDefaultParams(File file) {
        file.setLastModified(Calendar.getInstance().getTime());
        
    }

    private void setFileValues (File file, FileDTO fileDto){
        file.setName(fileDto.getName());
        file.setDmsPath(fileDto.getDmsPath());
        file.setFileSize(fileDto.getFileSize());
        file.setVersion(fileDto.getVersion());
        file.setLastModified(fileDto.getLastModified());
        file.setPrivateFile(fileDto.getPrivateFile());
    }

}
