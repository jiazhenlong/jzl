package com.shop.image;

import java.awt.image.BufferedImage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shop.enums.ImageRate;
import com.shop.enums.ImageType;
import com.shop.exception.BaseException;
import com.shop.exception.Errors;
import com.shop.utils.FileUploadUtil;
import com.shop.utils.IdGenUtil;



public class ImageConfigurationFactory {


  private static final String FILE_SEPARATOR = java.io.File.separator;
  private static final String URL_SEPARATOR = "/";
  private static final Logger LOG = LoggerFactory.getLogger(ImageConfigurationFactory.class);


  public static void checkImageRate(BufferedImage bufferedImage,
                                    ImageRate rate) {
    if (null == bufferedImage) {
      LOG.error("upload file can't read.");
      throw new BaseException(Errors.CoreServiceErrors.NOT_FOUND);
    }
    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();
    switch (rate) {
      case RATE16R9:
        if (width / height != 16 / 9) {
          throw new BaseException(Errors.ApiErrors.RATE_ERROR);
        }
        break;
      case RATE1R1:
        if (width / height != 1) {
          throw new BaseException(Errors.ApiErrors.RATE_ERROR);
        }
        break;
      default:
        throw new BaseException(Errors.ApiErrors.RATE_ERROR);

    }
  }


  public static String getUploadFileName(String filePath,
                                         String dateFolder,
                                         ImageType imageType,
                                         String fileName) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(filePath).append(FILE_SEPARATOR);
    buffer.append(dateFolder).append(FILE_SEPARATOR);
    generateUploadFolder(buffer.toString());
    buffer.append(imageType).append(FILE_SEPARATOR);
    generateUploadFolder(buffer.toString());
    buffer.append(IdGenUtil.get().nextId());
    if (fileName.lastIndexOf(".") != -1) {
      String suffix = fileName.substring(fileName.lastIndexOf("."));
      buffer.append(suffix);
    }
    return buffer.toString();
  }


  public static String getUploadUri(String uriPath) {

    return StringUtils.substringAfter(uriPath, FileUploadUtil.getImagePath()).replace(FILE_SEPARATOR, URL_SEPARATOR);

  }

  public static void generateUploadFolder(String folderPath) {
    java.io.File file = new java.io.File(folderPath);
    if (!file.exists() || !file.isDirectory()) {
      if (!file.mkdirs()) {
        LOG.error("Failed to create upload directory: " + folderPath);
        throw new RuntimeException();
      }
    }
  }


}
