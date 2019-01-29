package com.shop.api.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.service.AdsService;
import com.shop.api.vo.AdsBO;
import com.shop.api.vo.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/advertisement")
@Api(tags = "广告API")
public class AdvertisementController {

  @Autowired
  private AdsService adsService;
  



  @GetMapping("/list")
  @ApiOperation(value = "广告主获取广告列表")
  public ResultData findAdsListPage(@RequestParam(value = "shopId", required = true) long shopId, 
                                @ApiParam("排序：0-按创建时间倒序，1-佣金最高，2-佣金比最大") 
                                @RequestParam(value = "sort", required = false, defaultValue = "0") int sort, 
                                @ApiParam("-1:审核未通过 0:未审核 1:审核通过")
                                @RequestParam(value = "verify", required = false) Integer verify,
                                @RequestParam(value = "adsName", required = false) String adsName,
                                @ApiParam("页码，从1开始")
                                @RequestParam(value = "pageIndex", required = true) int pageIndex) {
    return new ResultData(adsService.findAdsListPage(shopId, sort, verify, adsName, pageIndex));
  }
  
  
  @PostMapping("/publish")
  @ApiOperation(value = "发布广告")
  public ResultData publishAds(@Valid @RequestBody AdsBO adsBO) {
    adsService.publishAds(adsBO);
    
    return new ResultData(true);
  }

  
  @GetMapping("/detail")
  @ApiOperation(value = "获取广告详情")
  public ResultData getAdsDetail(@RequestParam(value = "adsId", required = true) long adsId) {
    return new ResultData(adsService.getAdsDetail(adsId));
  }
  
  
  @PostMapping("/edit")
  @ApiOperation(value = "修改广告信息")
  public ResultData updateAds(@Valid @RequestBody AdsBO adsBO) {
    adsService.updateAds(adsBO);
    
    return new ResultData(true);
  }
  
  @GetMapping("/brieflist")
  @ApiOperation(value = "流量主查询广告列表")
  public ResultData findAdsBriefList(
                                @ApiParam("排序：0-按创建时间倒序，1-佣金最高，2-佣金比最大，3-投放次数倒序， 4-距离优先") 
                                @RequestParam(value = "sort", required = false, defaultValue = "0") int sort, 
                                @RequestParam(value = "adsName", required = false) String adsName,
                                @ApiParam("页码，从1开始")
                                @RequestParam(value = "pageIndex", required = true) int pageIndex) {
    return new ResultData(adsService.findAdsBriefList(sort, adsName, pageIndex));
  }
  
}
