package com.shop.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.Report;

/**  
*
* @Title:  ReportDao.java   
* @Package com.shop.dao.mysql   
* @Description:    TODO(商家报表)   
* @author: jiazhenlong     
* @date:   2018年5月25日 上午10:47:02   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
@Repository
public interface ReportDao {

  /**
   * 
   * @date:   2018年5月28日 下午4:14:07  
   * @Title: addReport   
   * @Description: TODO(新增报表信息)   
   * @param report      
   * @return: void       
   *
   */
  void addReport(@Param("report") Report report);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:14:03  
   * @Title: getReportById   
   * @Description: TODO(根据主键获取报表信息)   
   * @param id
   * @return      
   * @return: Report       
   *
   */
  Report getReportById(@Param("id") long id);
  
  /**
   * 
   * @date:   2018年5月28日 下午4:14:00  
   * @Title: delReportById   
   * @Description: TODO(根据主键删除报表信息)   
   * @param id      
   * @return: void       
   *
   */
  void delReportById(@Param("id") long id);
}
