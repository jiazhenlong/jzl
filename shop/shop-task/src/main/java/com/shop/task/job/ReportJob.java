package com.shop.task.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**  
*
* @Title:  ReportJob.java   
* @Package com.shop.task.job   
* @Description:    TODO(报表作业)   
* @author: jiazhenlong     
* @date:   2018年5月30日 下午3:32:59   
* @version V1.0 
* @Copyright: 2018 wehere All rights reserved. 
*/
public class ReportJob implements SimpleJob {
  
  private static final Logger LOG = LoggerFactory.getLogger(ReportJob.class);
  
  
  
  
  
  

  @Override
  public void execute(ShardingContext shardingContext) {
    LOG.info("开始生成报表");
    
  }

}
