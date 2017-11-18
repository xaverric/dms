package cz.uhk.fim.repository.dao;

import cz.uhk.fim.repository.entity.File;
import cz.uhk.fim.repository.dao.api.AbstractGenericDAO;
import cz.uhk.fim.repository.dao.api.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImpl extends AbstractGenericDAO<File> implements UserDao {
}
