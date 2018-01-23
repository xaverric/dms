package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.entity.File;

import java.util.List;

public interface FileService {

    List<File> findAllFiles();
}
