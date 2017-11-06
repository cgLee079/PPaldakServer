package com.cglee079.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cglee079.model.Fish;

@Repository
public class FishDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Fish getFish(String id) {
		String str = "SELECT * FROM fishs WHERE id = ?";
		return jdbcTemplate.queryForObject(str, new Object[] { id }, new FishMapper());
	}
	
	public List<Fish> getFishsByOwner(String owner) {
		String str = "SELECT * FROM fishs WHERE user_id = ? ORDER BY name ASC";
		return jdbcTemplate.query(str, new Object[] { owner }, new FishMapper());
	}

	public List<Fish> getFishsByOwnerAndFishname(String user_id, String fishname) {
		String str = "SELECT * FROM fishs WHERE user_id = ? AND name like ? ORDER BY name ASC";
		return jdbcTemplate.query(str, new Object[] { user_id, "%" + fishname + "%" }, new FishMapper());
	}

	public List<Fish> getFishsInPeriod(String st_time, String end_time) {
		String str = "SELECT * FROM fishs WHERE date BETWEEN ? AND ? ORDER BY name ASC";
		return jdbcTemplate.query(str, new Object[] { st_time, end_time }, new FishMapper());
	}

	public List<Fish> getFishsInPeriodBySpecies(String species, String st_time, String end_time) {
		String str = "SELECT * FROM fishs WHERE species like ? AND date BETWEEN ? AND ? ORDER BY name ASC";
		return jdbcTemplate.query(str, new Object[] { "%" + species + "%", st_time, end_time }, new FishMapper());
	}

	public boolean insert(Fish fish) {
		String sql = "INSERT INTO fishs(id, user_id,name, species, imgFile, maxFower, avgFower, date, time, timeing, GPS_lat, Gps_lot)"
				+ " VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		String id 		= fish.getId();
		String owner 	= fish.getOwner();
		String name 	= fish.getName();
		String species	= fish.getSpecies();
		String imgFile 	= fish.getImageFile();
		Double maxFower = fish.getMaxPower();
		Double avgFower = fish.getAvgPower();
		String date 	= fish.getDate();
		String time 	= fish.getTime();
		Integer timeing = fish.getTimeing();
		Double GPSLat 	= fish.getGPSLat();
		Double GPSLot 	= fish.getGPSLot();

		return jdbcTemplate.update(sql, new Object[] { id, owner, name, species, imgFile, maxFower, avgFower, date, time, timeing, GPSLat, GPSLot }) == 1;
	}
	
	public boolean delete(String id) {
		String sql = "DELETE FROM fishs WHERE id = ?"; 
		return jdbcTemplate.update(sql, new Object[] { id }) == 1;
	}

	class FishMapper implements RowMapper<Fish> {
		@Override
		public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
			Fish fish = new Fish();
			fish.setId(rs.getString("id"));
			fish.setOwner(rs.getString("user_id"));
			fish.setName(rs.getString("name"));
			fish.setSpecies(rs.getString("species"));
			fish.setImageFile(rs.getString("imgFile"));
			fish.setMaxPower(rs.getDouble("maxFower"));
			fish.setAvgPower(rs.getDouble("avgFower"));
			fish.setDate(rs.getString("date"));
			fish.setTime(rs.getString("time"));
			fish.setTimeing(rs.getInt("timeing"));
			fish.setGPSLat(rs.getDouble("GPS_lat"));
			fish.setGPSLot(rs.getDouble("GPS_lot"));

			return fish;
		}
	}

}
