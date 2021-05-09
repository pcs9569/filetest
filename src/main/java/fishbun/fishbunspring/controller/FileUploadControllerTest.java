package fishbun.fishbunspring.controller;

import fishbun.fishbunspring.domain.FileDomain;
import fishbun.fishbunspring.domain.FileUploadProperties;
import fishbun.fishbunspring.domain.FileUploadResponse;
import fishbun.fishbunspring.exception.FileUploadException;
import fishbun.fishbunspring.service.FileUpDownService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/api/files")
public class FileUploadControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadControllerTest.class);
    private final FileUpDownService fileUpDownService;

 /*

    public FileUploadControllerTest(FileUploadProperties prop){
        this.fileLocation = Paths.get(prop.getUploadDir()).toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.fileLocation);
        }catch (Exception e){
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }
*/

    @Autowired
    public FileUploadControllerTest(FileUpDownService fileUpDownService){
        this.fileUpDownService = fileUpDownService;

    }


    @PostMapping("/uploadFile")
    public FileDomain uploadFile(@RequestParam("file") MultipartFile file, Integer sto_id) {

        FileDomain fileDomain = new FileDomain();

        String file_origin_name = StringUtils.cleanPath(file.getOriginalFilename());
        String file_save_name = file_origin_name+now();
        long file_size = file.getSize();


        fileDomain.setSto_id(sto_id);
        fileDomain.setFile_origin_name(file_origin_name);
        fileDomain.setFile_save_name(file_save_name);
        fileDomain.setFile_size(file_size);

        fileUpDownService.save(file, fileDomain);

        return fileDomain;

    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<FileUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
//        // Load file as Resource
//        Resource resource = service.loadFileAsResource(fileName);
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
//
//


}
