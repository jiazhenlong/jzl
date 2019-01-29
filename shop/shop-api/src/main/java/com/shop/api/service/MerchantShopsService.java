package com.shop.api.service;

import java.util.List;

import com.shop.api.vo.EditPasswordBO;
import com.shop.api.vo.ForgetPasswordBO;
import com.shop.api.vo.LoginBO;
import com.shop.api.vo.LoginVO;
import com.shop.api.vo.MerchantShopBrief;
import com.shop.api.vo.MerchantShopsBO;
import com.shop.api.vo.MerchantShopsVO;
import com.shop.api.vo.ShopRegisterBO;

/**  
*
* @Title:  MerchantShopsService.java   
* @Package com.shop.api.service   
* @Description:    TODO(商家门店)   
* @author: jiazhenlong     
* @date:   2018年6月15日 下午3:47:39   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public interface MerchantShopsService {

  
  
  /**
   * 
   * @date:   2018年6月15日 下午3:50:50  
   * @Title: checkMerchantInfo   
   * @Description: TODO(检查商家信息是否完善)   
   * @param shopId
   * @return      
   * @return: boolean       
   *
   */
  boolean checkMerchantInfo(long shopId);
  
  /**
   * 
   * @date:   2018年6月22日 下午2:57:03  
   * @Title: updateMerchantShops   
   * @Description: TODO(修改商家门店)   
   * @param merchantShopsBO
   * @return      
   * @return: MerchantShopsVO       
   *
   */
  MerchantShopsVO updateMerchantShops(MerchantShopsBO merchantShopsBO);
  
  /**
   * 
   * @date:   2018年6月22日 下午2:59:05  
   * @Title: getMerchantShopsById   
   * @Description: TODO(根据id获取商家门店信息)   
   * @param shopId
   * @return      
   * @return: MerchantShopsVO       
   *
   */
  MerchantShopsVO getMerchantShopsById(long shopId);
  
  /**
   * 
   * @date:   2018年6月28日 下午3:01:49  
   * @Title: registerShop   
   * @Description: TODO(商家账号注册)   
   * @param shopRegisterBO      
   * @return: void       
   *
   */
  void registerShop(ShopRegisterBO shopRegisterBO);
  
  /**
   * 
   * @date:   2018年6月28日 下午5:07:27  
   * @Title: login   
   * @Description: TODO(登录)   
   * @param loginBO
   * @return      
   * @return: LoginVO       
   *
   */
  LoginVO login(LoginBO loginBO);
  
  /**
   * 
   * @date:   2018年6月29日 上午11:47:15  
   * @Title: forgetPassword   
   * @Description: TODO(找回密码)   
   * @param forgetPasswordBO      
   * @return: void       
   *
   */
  void forgetPassword(ForgetPasswordBO forgetPasswordBO);
  
  /**
   * 
   * @date:   2018年6月29日 上午11:47:58  
   * @Title: editPassword   
   * @Description: TODO(修改密码)   
   * @param editPasswordBO      
   * @return: void       
   *
   */
  void editPassword(EditPasswordBO editPasswordBO);

  /**
   * 查询附近的门店
   * @param shopId
   * @param distance 距离（千米）
 * @return 
   */
  List<MerchantShopBrief> nearbyShops(long shopId, double distance);
}
