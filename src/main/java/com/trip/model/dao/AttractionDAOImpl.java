package com.trip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.trip.dto.AttractionInfo;
import com.trip.dto.Sido;
import com.trip.util.DBUtil;

public class AttractionDAOImpl implements AttractionDAO {
	
	private DBUtil util;
	
	public AttractionDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<AttractionInfo> selectTop8() {
		ArrayList<AttractionInfo> alist = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			String q = "select content_id, title, addr1, first_image from attraction_info order by content_id limit 8";
			ResultSet rs = stat.executeQuery(q);
			
			while (rs.next()) {
				String content_id = rs.getString(1);
				String title = rs.getString(2);
				String addr1 = rs.getString(3);
				String first_image = rs.getString(4);
				if(first_image.equals("")) first_image = "assets/img/no_image.png";

				AttractionInfo attr = new AttractionInfo(content_id, title, addr1, first_image, null, null, null, null);
				alist.add(attr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alist;
	}

	@Override
	public ArrayList<Sido> getSidoList() {
		ArrayList<Sido> sidoList = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			String q = "select sido_code, sido_name from sido";
			ResultSet rs = stat.executeQuery(q);
			
			while (rs.next()) {
				String sido_code = rs.getString(1);
				String sido_name = rs.getString(2);

				Sido s = new Sido(sido_code, sido_name);
				sidoList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sidoList;
	}

	@Override
	public ArrayList<AttractionInfo> getAttractionListBySidoCode(String sido_code) {
		ArrayList<AttractionInfo> alist = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			String q = "select attraction_info.content_id, title, addr1, first_image, sido_code, latitude, longitude, overview "
					+ "from attraction_info "
					+ "join attraction_description on attraction_info.content_id = attraction_description.content_id "
					+ "where sido_code = ? "
					+ "order by attraction_info.content_id limit 10";
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, sido_code);
			ResultSet rs = stat.executeQuery();
			
			while (rs.next()) {
				String content_id = rs.getString(1);
				String title = rs.getString(2);
				String addr1 = rs.getString(3);
				String first_image = rs.getString(4);
				String latitude = rs.getString(6);
				String longitude = rs.getString(7);
				String overview = rs.getString(8);
				
				if(first_image.equals("")) first_image = "assets/img/no_image.png";

				AttractionInfo attr = new AttractionInfo(content_id, title, addr1, first_image, sido_code, latitude, longitude, overview);
				alist.add(attr);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alist;
	}

	@Override
	public AttractionInfo attractionDetail(String content_id) {

		AttractionInfo attr = null;

		try {
			Connection con = util.getConnection();
			String q = "select attraction_info.content_id, title, addr1, first_image, sido_code, latitude, longitude, overview "
					+ "from attraction_info "
					+ "join attraction_description on attraction_info.content_id = attraction_description.content_id "
					+ "where attraction_info.content_id = ? ";
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, content_id);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				String title = rs.getString(2);
				String addr1 = rs.getString(3);
				String first_image = rs.getString(4);
				String sido_code = rs.getString(5);
				String latitude = rs.getString(6);
				String longitude = rs.getString(7);
				String overview = rs.getString(8);

				if(first_image.equals("")) first_image = "assets/img/no_image.png";

				attr = new AttractionInfo(content_id, title, addr1, first_image, sido_code, latitude, longitude, overview);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attr;
	}
}
