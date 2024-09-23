package com.sondev.repository;

import com.sondev.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedReposiroty extends JpaRepository<FeedEntity,Long> {
}
