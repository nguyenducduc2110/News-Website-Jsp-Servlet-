package com.webspringmvc.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	public abstract T mapRow(ResultSet resultSet);
}
