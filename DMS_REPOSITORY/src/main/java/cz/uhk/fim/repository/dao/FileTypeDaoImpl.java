package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.FileTypeDao;
import cz.uhk.fim.repository.entity.FileType;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FileTypeDaoImpl extends AbstractGenericDAO<FileType> implements FileTypeDao {

    @Override
    public FileType addFileType(String name, String suffix, String description) {
        FileType ft = new FileType();
        ft.setName(name);
        ft.setDescription(description);
        ft.setSuffix(suffix);       
        getEntityManager().persist(ft);
        return ft;
    }

    @Override
    public List<FileType> getAllFileTypes() {
        List<FileType>listFileTypes = getEntityManager().createQuery("from FileType", FileType.class).getResultList();
        return listFileTypes;
    }

    @Override
    public FileType getFileTypeById(Long id) {
        FileType ft = getEntityManager().find(FileType.class, id);
        return ft;
    }

    @Override
    public FileType getFileTypeBySuffix(String suffix) {
        Query sql = getEntityManager().createQuery("from FileType where suffix = :suffix", FileType.class);
        sql.setParameter("suffix", suffix);
        return getSingleResult(sql);
    }
}
