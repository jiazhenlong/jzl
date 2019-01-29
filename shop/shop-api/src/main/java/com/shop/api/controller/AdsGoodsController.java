package com.shop.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.service.AdsGoodsService;
import com.shop.api.vo.AdsGoodsBO;
import com.shop.api.vo.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
*
* @Title:  AdsGoodsController.java   
* @Package com.shop.api.controller   
* @Description:    TODO(商品)   
* @author: jiazhenlong     
* @date:   2018年6月13日 上午10:04:49   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@RestController
@RequestMapping("/goods")
@Api(tags = "商品API")
public class AdsGoodsController {
  
  @Autowired
  private AdsGoodsService adsGoodsService;
  
  @PostMapping("/create")
  @ApiOperation(value = "新增商品")
  public ResultData crateAdsGoods(@Valid @RequestBody AdsGoodsBO adsGoodsBO) {
    return new ResultData(adsGoodsService.createAdsGoods(adsGoodsBO));
  }
  
  
  
  @GetMapping("/detail")
  @ApiOperation(value = "获取广告详情")
  public ResultData getGoodsDetail(@RequestParam(value = "adsId", required = true) long adsId) {
    return new ResultData(adsGoodsService.getGoodsDetail(adsId));
  }
  
  
  @PostMapping("/edit")
  @ApiOperation(value = "修改商品信息")
  public ResultData updateAdsGoods(@Valid @RequestBody AdsGoodsBO adsGoodsBO) {
    adsGoodsService.updateAdsGoods(adsGoodsBO);
    
    return new ResultData(true);
  }
  
}
