package com.trip.model.service;

import java.util.ArrayList;

import com.trip.dto.AttractionInfo;
import com.trip.dto.Sido;
import com.trip.model.dao.AttractionDAO;
import com.trip.model.dao.AttractionDAOImpl;

public class AttractionServiceImpl implements AttractionService {
	
	AttractionDAO adao;
	
	public AttractionServiceImpl() {
		adao = new AttractionDAOImpl();
	}

	@Override
	public ArrayList<AttractionInfo> selectTop8() {
		return adao.selectTop8();
	}

	@Override
	public ArrayList<Sido> getSidoList() {
		return adao.getSidoList();
	}

	@Override
	public ArrayList<AttractionInfo> getAttractionListBySidoCode(String sido_code) {
		return adao.getAttractionListBySidoCode(sido_code);
	}

	@Override
	public AttractionInfo attractionDetail(String content_id) {
		return adao.attractionDetail(content_id);
	}
}
