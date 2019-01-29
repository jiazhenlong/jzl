package com.shop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.mysql.MembersDao;
import com.shop.model.Members;
import com.shop.service.MembersCoreService;


/**  
*
* @Title:  MembersCoreServiceImpl.java   
* @Package com.shop.service.impl   
* @Description:    TODO(会员)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午11:20:02   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Service
public class MembersCoreServiceImpl implements MembersCoreService {
  
  @Autowired
  private MembersDao membersDao;
  

  @Override
  public Optional<Members> getMembersById(long id) {
    return Optional.ofNullable(membersDao.getMembersById(id));
  }

}
