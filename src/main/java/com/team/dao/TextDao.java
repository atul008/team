package com.team.dao;

import org.springframework.data.repository.CrudRepository;

import com.team.entity.TextEntity;

public interface TextDao extends CrudRepository<TextEntity, Integer>{

}
