package com.shop.api.vo;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

/**  
*
* @Title:  AdsBO.java   
* @Package com.shop.api.vo   
* @Description:    TODO(广告业务对象)   
* @author: jiazhenlong     
* @date:   2018年6月8日 下午4:09:03   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class AdsBO {

  
  /**
   * 
   */
  private long id;
  
  /**
   * 标题
   */
  @Pattern(regexp = "[^'\"<>=&]{1,}", message = "广告参数非法，参数不能包含以下非法字符 ' \" < > = &")
  @NotNull(message = "广告标题不能为空")
  @Length(min = 1, max = 30, message = "广告标题过长")
  private String title;
  
  /**
   * 出价方式 0:cps
   */
  private Integer cosType;
  
  /**
   * 跳转地址
   */
  private String url;
  
  /**
   * 佣金比例
   */
  @NotNull(message = "佣金比例必填")
  @DecimalMin(value="0", message = "佣金必须大于等于0")
  private Double commissionRate;
  
  /**
   * -1:审核未通过 0:未审核 1:审核通过
   */
  private Integer verify = 0;
  
  /**
   * 广告类型: 0-自有商品; 1-他人商品
   */
  @NotNull(message = "广告类型必填")
  private Integer adsType;
  
  /**
   * 广告所属广告主
   */
  @NotNull(message = "广告所属人必填")
  private Long shopId;
  
  /**
   * 广告关联商品id
   */
  @NotNull(message = "广告关联商品主键必填")
  private Long goodsId;
  
  /**
   * 图片主键
   */
  @NotNull(message = "广告关联图片必填")
  private List<Long> imgIdList;
  
  /**
   * 版本号
   */
  private int version;
  

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getCosType() {
    return cosType;
  }

  public void setCosType(Integer cosType) {
    this.cosType = cosType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Double getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(Double commissionRate) {
    this.commissionRate = commissionRate;
  }

  public Integer getVerify() {
    return verify;
  }

  public void setVerify(Integer verify) {
    this.verify = verify;
  }

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
  }  
  
  public List<Long> getImgIdList() {
    return imgIdList;
  }

  public void setImgIdList(List<Long> imgIdList) {
    this.imgIdList = imgIdList;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Integer getAdsType() {
    return adsType;
  }

  public void setAdsType(Integer adsType) {
    this.adsType = adsType;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
