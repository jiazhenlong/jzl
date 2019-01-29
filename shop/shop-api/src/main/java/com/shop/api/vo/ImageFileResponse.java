package com.shop.api.vo;

import io.swagger.annotations.ApiModelProperty;

public class ImageFileResponse {

  @ApiModelProperty(value = "图片URL路径")
  private String path;
  @ApiModelProperty(value = "图片文件大小")
  private Long size;
  @ApiModelProperty(value = "图片ID对应数据库id")
  private Long imageId;

  public ImageFileResponse() {

  }

  public ImageFileResponse(String path, Long imageId, Long size) {
    this.path = path;
    this.size = size;
    this.imageId = imageId;
  }



  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }
}
