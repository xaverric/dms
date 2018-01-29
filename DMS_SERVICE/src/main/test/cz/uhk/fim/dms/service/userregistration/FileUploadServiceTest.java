package cz.uhk.fim.dms.service.userregistration;

import cz.uhk.fim.dms.service.api.ResultInfo;
import cz.uhk.fim.dms.service.api.userlogin.SecurityService;
import cz.uhk.fim.dms.service.file.FileUploadServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

import static org.mockito.Mockito.when;

public class FileUploadServiceTest {

    @InjectMocks
    private FileUploadServiceImpl fileUploadService;

    @Mock
    private SecurityService securityService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        when(securityService.findLoggedInUsername()).thenReturn("user");
    }

    @Test
    public void testUploadFile(){
        MultipartFile file = new MockMultipartFile("fileName", "filename.txt", "text", new byte[]{1,1,1,});
        ResultInfo<Path> result = fileUploadService.uploadFile(file);
        Assert.assertEquals(ResultInfo.Status.SUCCESS, result.getStatus());
    }
}
