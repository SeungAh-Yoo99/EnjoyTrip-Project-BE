package com.trip.model.service;

import java.util.ArrayList;

import com.trip.dto.AttractionInfo;
import com.trip.dto.Sido;

public interface AttractionService {

	ArrayList<AttractionInfo> selectTop8();

	ArrayList<Sido> getSidoList();

	ArrayList<AttractionInfo> getAttractionListBySidoCode(String sido_code);

	AttractionInfo attractionDetail(String content_id);

}
