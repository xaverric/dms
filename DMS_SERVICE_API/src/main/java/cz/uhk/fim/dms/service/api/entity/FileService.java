package cz.uhk.fim.dms.service.api.entity;

import cz.uhk.fim.repository.dto.api.FileDTO;
import cz.uhk.fim.repository.entity.File;

import java.util.List;

public interface FileService {

    File getFileByID(Long id);

    File getFileByNameUsername(String fileName, String username);

    File getFileByUsername();

    File addFile(FileDTO fileDto);

    File deleteFileVersion(FileDTO fileDto, Long version);

    List<File> findAllFiles();
}
