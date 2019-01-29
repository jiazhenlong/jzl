package com.shop.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.service.MerchantShopsService;
import com.shop.api.vo.EditPasswordBO;
import com.shop.api.vo.ForgetPasswordBO;
import com.shop.api.vo.LoginBO;
import com.shop.api.vo.MerchantShopBrief;
import com.shop.api.vo.MerchantShopsBO;
import com.shop.api.vo.ResultData;
import com.shop.api.vo.ShopRegisterBO;
import com.shop.constant.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
*
* @Title:  MerchantShopsController.java   
* @Package com.shop.api.controller   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年6月15日 下午4:37:48   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@RestController
@RequestMapping("/shops")
@Api(tags = "商家API")
public class MerchantShopsController {

  @Autowired
  private MerchantShopsService merchantShopsService;
  
  
  @GetMapping("/check/merchant-info")
  @ApiOperation(value = "检查商家信息是否完善")
  public ResultData checkMerchantInfo(long shopId) {
    return new ResultData(merchantShopsService.checkMerchantInfo(shopId));
  }
  
  
  @PostMapping("/register")
  @ApiOperation(value = "商家账号注册")
  public ResultData registerShop(@Valid @RequestBody ShopRegisterBO shopRegisterBO) {
    merchantShopsService.registerShop(shopRegisterBO);
    return new ResultData(true);
  }
  
  @PostMapping("/edit")
  @ApiOperation(value = "修改商家")
  public ResultData updateMerchantShops(@Valid @RequestBody MerchantShopsBO merchantShopsBO) {
    
    return new ResultData(merchantShopsService.updateMerchantShops(merchantShopsBO));
  }
  
  
  @GetMapping("/detail")
  @ApiOperation(value = "根据主键获取商家信息")
  public ResultData getMerchantShopsById(long shopId) {
    return new ResultData(merchantShopsService.getMerchantShopsById(shopId));
  }
  
  @GetMapping("/validate")
  @ApiOperation(value = "认证码")
  public ResultData getValidateNo() {
    return new ResultData(Constants.DEFAULT_VALIDATE_NO);
  }
  
  
  @PostMapping("/login")
  @ApiOperation(value = "登录")
  public ResultData login(@Valid @RequestBody LoginBO loginBO) {
    
    return new ResultData(merchantShopsService.login(loginBO));
  }
  
  
  @PostMapping("/forget-pw")
  @ApiOperation(value = "找回密码")
  public ResultData forgetPassword(@Valid @RequestBody ForgetPasswordBO forgetPasswordBO) {
    merchantShopsService.forgetPassword(forgetPasswordBO);
    return new ResultData(true);
  }
  
  
  @PostMapping("/edit-pw")
  @ApiOperation(value = "修改密码")
  public ResultData editPassword(@Valid @RequestBody EditPasswordBO editPasswordBO) {
    merchantShopsService.editPassword(editPasswordBO);;
    return new ResultData(true);
  }
  
  @GetMapping("/nearby")
  @ApiOperation(value = "查找附近的门店")
  public ResultData nearbyShops(Long shopId, Double distance) {
	  List<MerchantShopBrief> shopList = merchantShopsService.nearbyShops(shopId, distance);
    return new ResultData(shopList);
  }
  
}
