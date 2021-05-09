package fishbun.fishbunspring.service;

import fishbun.fishbunspring.domain.FileUploadProperties;

import fishbun.fishbunspring.exception.FileDownloadException;
import fishbun.fishbunspring.exception.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadDownloadService {

    private final Path fileLocation;
//    파일이 저장될 디렉터리를 설정하고 디렉터리를 생상하는 소스 추가
//    Service가 실행될때 생성자에서 기존에 생성한 설정클래스인 FileUploadProperties 클래스로 기본 디렉토리를 설정하고 생성한다.
    @Autowired
    public FileUploadDownloadService(FileUploadProperties prop){
        this.fileLocation = Paths.get(prop.getUploadDir()).toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.fileLocation);
        }catch (Exception e){
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

//    파일을 저장하는 소스
//    StringUtils - import org.springframework.util.StringUtils;
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // 파일명에 부적합 문자가 있는지 확인한다.
            if(fileName.contains(".."))
                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);

            Path targetLocation = this.fileLocation.resolve(fileName);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        }catch(Exception e) {
            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
        }
    }

//    파일을 다운로드 하는 소스
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()) {
                return resource;
            }else {
                throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
            }
        }catch(MalformedURLException e) {
            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.", e);
        }
    }




}
