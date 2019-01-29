package com.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.shop.dao.es.MerchantShopEsDao;
import com.shop.dao.es.doc.MerchantShopEsDoc;
import com.shop.model.MerchantShops;
import com.shop.utils.GDGeoUtil;

@Aspect
@Component
public class ESIndexAspect {
	
	@Autowired
	private MerchantShopEsDao merchantShopEsDao;

	@Pointcut("@annotation(ImportES)")
	public void pointESIndex() {
	}

	@AfterReturning(pointcut = "pointESIndex()")
	@Async
	public void afterReturn(JoinPoint jp) {

		Object[] args = jp.getArgs();

		for (Object obj : args) {
			if (obj instanceof MerchantShops) {
				// 新增门店
				MerchantShops merShop = (MerchantShops) obj;

				MerchantShopEsDoc doc = new MerchantShopEsDoc();
				doc.setShop_id(merShop.getId());
				doc.setMerchant_id(merShop.getMerchantId());
				doc.setName(merShop.getName());
				doc.setComment(merShop.getComment());
				doc.setAddr(merShop.getAddress());

				doc.setLocation(GDGeoUtil.getGeoPoint(null, doc.getAddr()));

				merchantShopEsDao.index(doc.getShop_id().toString(), doc);
				
			}
		}

	}
}
