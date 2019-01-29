package com.shop.api.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.geo.GeoPoint;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.api.service.MerchantShopsService;
import com.shop.api.vo.EditPasswordBO;
import com.shop.api.vo.ForgetPasswordBO;
import com.shop.api.vo.LoginBO;
import com.shop.api.vo.LoginVO;
import com.shop.api.vo.MerchantShopBrief;
import com.shop.api.vo.MerchantShopsBO;
import com.shop.api.vo.MerchantShopsVO;
import com.shop.api.vo.ShopRegisterBO;
import com.shop.constant.Constants;
import com.shop.dao.es.doc.MerchantShopEsDoc;
import com.shop.enums.AdsActive;
import com.shop.enums.VerifyStatus;
import com.shop.exception.ApiException;
import com.shop.exception.Errors;
import com.shop.model.MerchantShops;
import com.shop.model.Merchants;
import com.shop.service.MerchantShopEsService;
import com.shop.service.MerchantShopsCoreService;
import com.shop.service.MerchantsCoreService;
import com.shop.utils.GDGeoUtil;
import com.shop.utils.MD5Utils;


/**  
*
* @Title:  MerchantShopsServiceImpl.java   
* @Package com.shop.api.service.impl   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年6月15日 下午3:48:31   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class MerchantShopsServiceImpl implements MerchantShopsService {

  private static final Logger LOG = LoggerFactory.getLogger(MerchantShopsServiceImpl.class);
  
  @Autowired
  private MerchantShopsCoreService merchantShopsCoreService;
  
  @Autowired
  private MerchantsCoreService merchantsCoreService;
  
  @Autowired
  private MerchantShopEsService merchantShopEsService;
  
  
  
  @Override
  public LoginVO login(LoginBO loginBO) {
    String password = merchantShopsCoreService.getPasswordByMobile(loginBO.getMobile());
    
    if (StringUtils.isBlank(password)) {
      LOG.error(MessageFormat.format("商家登录失败,{0}", loginBO));
      
      throw new ApiException(Errors.ApiErrors.LOGIN_NAME_IS_ERROR, new Object[] {"登录账号错误, loginBO:" + loginBO});
    }
    
    String pw = MD5Utils.digest(loginBO.getMobile().trim() + loginBO.getPassword().trim());
    
    if (!pw.equals(password)) {
      LOG.error(MessageFormat.format("商家登录失败,{0}", loginBO));
      
      throw new ApiException(Errors.ApiErrors.LOGIN_PASSWORD_IS_ERROR, new Object[] {"登录密码错误, loginBO:" + loginBO});
    }
    
    
    LoginVO loginVO = new LoginVO();
    
    
    return loginVO;
  }
  
  @Override
  public void forgetPassword(ForgetPasswordBO forgetPasswordBO) {
    if (Constants.DEFAULT_VALIDATE_NO != forgetPasswordBO.getValidateNo()) {
      LOG.error(MessageFormat.format("找回密码失败,{0}", forgetPasswordBO));
      
      throw new ApiException(Errors.ApiErrors.VALIDATE_IS_ERROR, new Object[] {"验证码错误, forgetPasswordBO:" + forgetPasswordBO});
    }
    
    if (!forgetPasswordBO.getPasswordNew().trim().equals(forgetPasswordBO.getPasswordSure().trim())) {
      LOG.error(MessageFormat.format("找回密码失败,{0}", forgetPasswordBO));
      
      throw new ApiException(Errors.ApiErrors.PASSWORD_NOT_AGREE, new Object[] {"两次输入密码不一致, forgetPasswordBO:" + forgetPasswordBO});
    }
    
    if (StringUtils.isBlank(merchantShopsCoreService.getPasswordByMobile(forgetPasswordBO.getMobile()))) {
      LOG.error(MessageFormat.format("找回密码失败,{0}", forgetPasswordBO));
      
      throw new ApiException(Errors.ApiErrors.LOGIN_NAME_IS_ERROR, new Object[] {"登录账号错误, forgetPasswordBO:" + forgetPasswordBO});
    }
    
    merchantShopsCoreService.updatePassword(forgetPasswordBO.getMobile(), 
      MD5Utils.digest(forgetPasswordBO.getMobile().trim() + forgetPasswordBO.getPasswordSure().trim()), DateTime.now().toDate());
  }



  @Override
  public void editPassword(EditPasswordBO editPasswordBO) {
    if (!editPasswordBO.getPasswordNew().trim().equals(editPasswordBO.getPasswordSure().trim())) {
      LOG.error(MessageFormat.format("修改密码失败,{0}", editPasswordBO));
      
      throw new ApiException(Errors.ApiErrors.PASSWORD_NOT_AGREE, new Object[] {"两次输入密码不一致, editPasswordBO:" + editPasswordBO});
    }
    
    String password = merchantShopsCoreService.getPasswordByMobile(editPasswordBO.getMobile());
    
    String passwordOld = MD5Utils.digest(editPasswordBO.getMobile().trim() + editPasswordBO.getPasswordOld().trim());
    
    if (!passwordOld.equals(password)) {
      LOG.error(MessageFormat.format("修改密码失败,{0}", editPasswordBO));
      
      throw new ApiException(Errors.ApiErrors.LOGIN_PASSWORD_IS_ERROR, new Object[] {"原密码错误, editPasswordBO:" + editPasswordBO});
    }
    
    merchantShopsCoreService.updatePassword(editPasswordBO.getMobile(), 
      MD5Utils.digest(editPasswordBO.getMobile().trim() + editPasswordBO.getPasswordSure().trim()), DateTime.now().toDate());
    
  }

  @Override
  public void registerShop(ShopRegisterBO shopRegisterBO) {
    if (Constants.DEFAULT_VALIDATE_NO != shopRegisterBO.getValidateNo()) {
      LOG.error(MessageFormat.format("商家账号注册失败,{0}", shopRegisterBO));
      
      throw new ApiException(Errors.ApiErrors.VALIDATE_IS_ERROR, new Object[] {"验证码错误, shopRegisterBO:" + shopRegisterBO});
    }
    MerchantShops merchantShops = new MerchantShops();
    
    merchantShops.setMobile(shopRegisterBO.getMobile());
    merchantShops.setPassword(MD5Utils.digest(shopRegisterBO.getMobile().trim() + shopRegisterBO.getPassword().trim()));
    merchantShops.setCreatedTime(DateTime.now().toDate());
    merchantShops.setUpdatedTime(DateTime.now().toDate());
    merchantShops.setIsActive(AdsActive.ACTIVE_NO.getCode());
    merchantShops.setVerify(VerifyStatus.AUDIT_NOT.getCode());
    
    merchantShopsCoreService.addMerchantShops(merchantShops);
  }


  @Override
  public MerchantShopsVO updateMerchantShops(MerchantShopsBO merchantShopsBO) {
    MerchantShops merchantShops = new MerchantShops();
    
    BeanUtils.copyProperties(merchantShopsBO, merchantShops);
    
    merchantShops.setUpdatedTime(DateTime.now().toDate());
    
    merchantShopsCoreService.updateMerchantShops(merchantShops);
    
    MerchantShopsVO merchantShopsVO = new MerchantShopsVO();
    
    BeanUtils.copyProperties(merchantShops, merchantShopsVO);
    
    return merchantShopsVO;
  }



  @Override
  public MerchantShopsVO getMerchantShopsById(long shopId) {
    MerchantShops merchantShops = merchantShopsCoreService.getMerchantShopsById(shopId);
    
    MerchantShopsVO merchantShopsVO = new MerchantShopsVO();
    
    BeanUtils.copyProperties(merchantShops, merchantShopsVO);
    return merchantShopsVO;
  }
  
  
  @Override
  public boolean checkMerchantInfo(long shopId) {
    
    MerchantShops merchantShops = merchantShopsCoreService.getMerchantShopsById(shopId);
    
    LOG.info(MessageFormat.format("检查商家资料, {0}", merchantShops));
    
    if (merchantShops == null) {
      return false;
    }
    
    if (StringUtils.isBlank(merchantShops.getName())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchantShops.getAddress())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchantShops.getComment())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchantShops.getContact())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchantShops.getMobile())) {
      return false;
    }
    
    if (merchantShops.getMerchantId() < 1) {
      return false;
    }
    
    Merchants merchants = merchantsCoreService.getMerchantsById(merchantShops.getMerchantId());
    
    LOG.info(MessageFormat.format("检查商家资料, {0}", merchants));
    
    if (merchants == null) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getName())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getComment())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getContact())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getEmail())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getLicense())) {
      return false;
    }
    
    if (StringUtils.isBlank(merchants.getMobile())) {
      return false;
    }
    
    return true;
  }

	@Override
	public List<MerchantShopBrief> nearbyShops(long shopId, double distance) {
		//获取门店信息
		MerchantShops shop = merchantShopsCoreService.getMerchantShopsById(shopId);
		if (shop == null || StringUtils.isBlank(shop.getAddress())) {
			throw new ApiException(Errors.ApiErrors.DATA_NOT_EXIST, new Object[] {"门店不存在 或者 门店地址不存在："+shop});
		}
		
		//获取门店经纬度
		GeoPoint geoPoint = GDGeoUtil.getGeoPoint(null, shop.getAddress());
		
		if (geoPoint == null) {
			throw new ApiException(Errors.ApiErrors.SYSTEM_ERROR, new Object[] {"无法获取高德经纬度"});
		}
		
		//在es中查询附近门店
		List<MerchantShopEsDoc> nearbyShops = merchantShopEsService.nearbyShops(geoPoint.getLon(), geoPoint.getLat(), distance);
		
		List<MerchantShopBrief> shopList = new ArrayList<>();
		for(MerchantShopEsDoc doc:nearbyShops) {
			MerchantShopBrief brief = new MerchantShopBrief();
			BeanUtils.copyProperties(doc, brief);
			brief.setShopId(doc.getShop_id());
			brief.setMerchantId(doc.getMerchant_id());
			shopList.add(brief);
		}
		return shopList;
	}

}
