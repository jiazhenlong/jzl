package com.shop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.api.vo.ResultData;
import com.shop.dao.es.doc.AdsEsDoc;
import com.shop.service.es.AdsEsService;

@RestController
@RequestMapping("/ads/es")
public class AdsEsController {

	@Autowired
	private AdsEsService adsEsService;

	@PostMapping("/index")
	public ResultData index(AdsEsDoc doc) {
		return new ResultData(adsEsService.indexAds(doc));
	}

	@DeleteMapping("/delete")
	public ResultData delete(String id) {
		return new ResultData(adsEsService.deleteAds(id));
	}

	@GetMapping("/all")
	public ResultData searchAll(Integer from, Integer size) {
		return new ResultData(adsEsService.searchAll(from, size));
	}

	@GetMapping("/search")
	public ResultData searchByField(String field, String value, Integer from, Integer size) {
		return new ResultData(adsEsService.searchByField(field, value, from, size));
	}

}
