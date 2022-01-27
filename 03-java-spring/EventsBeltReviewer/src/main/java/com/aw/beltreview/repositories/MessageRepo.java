package com.aw.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aw.beltreview.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
	List<Message> findAll();
	List<Message> findAllByEventId(Long id);
}
