package com.webspringmvc.dao.impl;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.webspringmvc.core.dto.NewsDTO;
import com.webspringmvc.dao.INewsDAO;
import com.webspringmvc.mapper.NewsMapper;
import com.webspringmvc.paging.Pageable;

@Repository
public class NewsDAO extends AbstractDAO<NewsDTO> implements INewsDAO{
	
	@Override
	public NewsDTO findByCategoryId(Long id) {	
		return super.queryList("select * from news where = ?", new NewsMapper(), id).get(0);
	}

	@Override
	public Long save(NewsDTO newsDTO) {
		String sql = "insert into news(title, thumbnail, shortdescription, content, categoryid,"
				+ "createddate,  modifieddate, createdby, modifiedby) values(?,?,?,?,?,?,?,?,?);";
		return insert(sql, newsDTO.getTitle(), newsDTO.getThumbnail(),newsDTO.getShortDescription(), newsDTO.getContent(), newsDTO.getCategoryId(), newsDTO.getCreatedDate(), newsDTO.getModifiedDate(), newsDTO.getCreatedBy(), newsDTO.getModifiedBy());
	}
	@Override
	public void update(NewsDTO updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getModifiedDate(), 
				updateNew.getModifiedBy(), updateNew.getId());
	}
	@Override
	public NewsDTO findOne(Long id) {
		ArrayList<NewsDTO> arrayList = super.queryList("select * from news where id = ?;", new NewsMapper(), id);
		return arrayList.isEmpty() ? null: arrayList.get(0);
	}

	@Override
	public void delete(Long id) {
		super.update("delete from news where id = ?;", id);
	}

	@Override
	public ArrayList<NewsDTO> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("select * from news");









		if( pageable.getSorter() != null && StringUtils.isNotBlank(pageable.getSorter().getSortBy()) && StringUtils.isNotBlank(pageable.getSorter().getSortBy())) {
			sql.append(" order by "+pageable.getSorter().getSortName()+" "+pageable.getSorter().getSortBy()+"");
		}
		if(pageable.getOffset()!= null && pageable.getLimit()!= null) {
			sql.append(" limit "+pageable.getOffset()+", "+pageable.getLimit()+" ");
		}	
		return super.queryList(sql.toString(), new NewsMapper());
	}
	
	
	






















}
