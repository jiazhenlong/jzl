package com.shop.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shop.enums.ImageRate;
import com.shop.enums.ImageType;
import com.shop.image.ImageConfigurationFactory;
import com.shop.service.ImagesService;
import com.shop.utils.DateUtil;
import com.shop.utils.FileUploadUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.shop.api.vo.ImageFileResponse;


@RestController
@RequestMapping("/upload")
@Api(value = "FileUploadController")
public class FileUploadController {
  
  private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);
  


  @Autowired
  private ImagesService imagesService;



  @PostMapping()
  @ApiOperation(value = "图片上传")
  public ImageFileResponse singleFileUpload(@RequestParam("file") MultipartFile file,
                                            @RequestParam(name = "image_size", required = false) ImageRate imageRate,
                                            @RequestParam(name = "image_type",defaultValue ="OTHER" ,required = false) ImageType imageType) {

    ImageFileResponse result = null;
    if (file.isEmpty()) {
      return result;
    }

    try {

      String name = file.getOriginalFilename();

      String targetFileName =
          ImageConfigurationFactory.getUploadFileName(FileUploadUtil.getImagePath(),
              DateUtil.getCurrentDateString("yyyy-MM-dd"), imageType, name);
      String targetUri = ImageConfigurationFactory.getUploadUri(targetFileName);

      // 写入文件
      byte[] bytes = file.getBytes();
      Path path = Paths.get(targetFileName);
      LOG.info("targetFileName = " + path);
      
      Files.write(path, bytes);
      Long id = -1L;
      if (imageType != ImageType.OTHER) {
        // 保存到数据库
        if (imageType == ImageType.ADVERTISEMENT) {
          id = imagesService.insertAds(targetUri, imageType, imageRate);
        }

        if (imageType == ImageType.GOODS) {
          id = imagesService.insertGoods(targetUri, imageType, imageRate);
        }
      }

      result = new ImageFileResponse(targetUri, id, file.getSize());

    } catch (

    IOException e) {
      e.printStackTrace();
    }

    return result;
  }



}
