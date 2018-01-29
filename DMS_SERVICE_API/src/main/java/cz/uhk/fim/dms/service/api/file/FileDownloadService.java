package cz.uhk.fim.dms.service.api.file;

import cz.uhk.fim.repository.entity.File;

public interface FileDownloadService {

    java.io.File downloadFile(File file);
}
