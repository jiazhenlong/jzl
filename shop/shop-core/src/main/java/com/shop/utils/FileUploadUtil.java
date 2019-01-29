package com.shop.utils;

public class FileUploadUtil {



  private static String imagePath = "/usr/share/nginx/html/static/images";
  
  private static String imageServer = "";
  

  public static String getDateFolder() {
    return DateUtil.getCurrentDateString("yyyyMMdd");
  }

  public static String  getImageServer() {
    return imageServer;
  }

  public static String getImagePath() {
    return imagePath;
  }

  public static void setImagePath(String imagePath) {
    FileUploadUtil.imagePath = imagePath;
  }


}
