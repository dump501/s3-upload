package com.dump501.s3upload.controller;

import com.dump501.s3upload.service.FileService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
@Slf4j
public class UploadController {
    private final FileService fileService;

    @GetMapping("upload_url")
    public ResponseEntity<Map<String, String>> getPresignedUrl(@RequestParam String fileName){
        log.info(fileName);
        String url = fileService.getPresignedUrl(fileName);
        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
