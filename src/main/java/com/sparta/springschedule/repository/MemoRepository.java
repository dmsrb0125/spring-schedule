package com.sparta.springschedule.repository;

import com.sparta.springschedule.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
