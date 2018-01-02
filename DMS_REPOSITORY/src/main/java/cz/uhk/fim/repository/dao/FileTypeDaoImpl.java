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
        return getEntityManager().createQuery("from FileType", FileType.class).getResultList();
    }

    @Override
    public FileType getFileTypeById(Long id) {
        return getEntityManager().find(FileType.class, id);
    }

    @Override
    public FileType getFileTypeBySuffix(String suffix) {
        Query sql = getEntityManager().createQuery("from FileType where suffix = :suffix", FileType.class);
        sql.setParameter("suffix", suffix);
        return getSingleResult(sql);
    }

    @Override
    public FileType updateFileTypeDescription(Long id, String description) {
        FileType ft = getFileTypeById(id);
        if (ft != null) {
            ft.setDescription(description);
        }
        return ft;
    }

    @Override
    public FileType updateFileTypeName(Long id, String name) {
        FileType ft = getFileTypeById(id);
        if (ft != null) {
            ft.setName(name);
        }
        return ft;
    }

    @Override
    public FileType updateFileTypeSuffix(Long id, String suffix) {
        FileType ft = getFileTypeById(id);
        if (ft != null) {
            ft.setSuffix(suffix);
        }
        return ft;
    }

}
