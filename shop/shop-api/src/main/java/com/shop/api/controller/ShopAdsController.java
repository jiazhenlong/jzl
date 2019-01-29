package com.shop.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.base.permission.Access;
import com.shop.api.base.permission.PermissionConstants;
import com.shop.api.service.ShopAdsService;
import com.shop.api.vo.ResultData;
import com.shop.api.vo.ShopAdsBO;
import com.shop.api.vo.ShopAdsBatchBO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**  
*
* @Title:  ShopAdsController.java   
* @Package com.shop.api.controller   
* @Description:    TODO(广告投放)   
* @author: jiazhenlong     
* @date:   2018年6月25日 下午2:26:22   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@RestController
@RequestMapping("/shop-ads")
@Api(tags = "广告投放API")
public class ShopAdsController {

  @Autowired
  private ShopAdsService shopAdsService;
  
  
  @Access(PermissionConstants.ADS_SHOP_CREATE)
  @PostMapping("/create")
  @ApiOperation(value = "单个广告投放")
  public ResultData crateShopAds(@Valid @RequestBody ShopAdsBO shopAdsBO) {
    shopAdsService.createShopAds(shopAdsBO);
    
    return new ResultData(true);
  }
  
  
  @PostMapping("/batch-create")
  @ApiOperation(value = "批量投放广告")
  public ResultData batchCreateShopAds(@Valid @RequestBody ShopAdsBatchBO shopAdsBatchBO) {
    shopAdsService.batchCreateShopAds(shopAdsBatchBO);
    
    return new ResultData(true);
  }
  
  
  @GetMapping("/list-page")
  @ApiOperation(value = "广告投放管理列表")
  public ResultData findShopAdsListPage(@ApiParam("广告所属商家id") 
                                    @RequestParam(value = "shopId", required = true) Long adsShopId, 
                                    @ApiParam("投放状态 0:投放未开始 1:正常投放 2:投放结束") 
                                    @RequestParam(value = "status", required = false) Integer status,
                                    @ApiParam("-1:审核未通过 0:未审核 1:审核通过")
                                    @RequestParam(value = "verify", required = false) Integer verify,
                                    @RequestParam(value = "title", required = false) String title,
                                    @ApiParam("页码，从1开始")
                                    @RequestParam(value = "pageIndex", required = true) int pageIndex) {
   
    return new ResultData(shopAdsService.findShopAdsListPage(adsShopId, verify, status, title, pageIndex));
  }
  
  
  @PostMapping("/del/{id}")
  @ApiOperation(value = "根据广告投放主键删除投放信息")
  public ResultData delShopAds(@PathVariable(value = "id", required = true) Long id) {
    shopAdsService.delShopAdsById(id);;
    
    return new ResultData(true);
  }
  
  @GetMapping("/detail")
  @ApiOperation(value = "获取广告投放详情")
  public ResultData getShopAdsDetailById(@ApiParam("广告投放id")  @RequestParam(value = "id", required = true) Long id) {
    return new ResultData(shopAdsService.getShopAdsDetailById(id));
  }
}
