package com.webspringmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.webspringmvc.core.dto.CategoryDTO;


public class CategoryMapper implements IRowMapper<CategoryDTO>{

	@Override
	public CategoryDTO mapRow(ResultSet resultSet) {
		try {
				CategoryDTO categoryDTO = new CategoryDTO();		
				categoryDTO.setId(resultSet.getLong("id"));
				categoryDTO.setCode(resultSet.getString("code"));
				categoryDTO.setName(resultSet.getString("name"));
				categoryDTO.setCreatedDate(resultSet.getTimestamp("createddate"));
				categoryDTO.setModifiedDate(resultSet.getTimestamp("modifieddate"));
				categoryDTO.setCreatedBy(resultSet.getString("createdby"));
				categoryDTO.setModifiedBy(resultSet.getString("modifiedby"));
				return categoryDTO;
			
		} catch (SQLException e) {
			return null;
		}
	}
}
