package com.sparta.springschedule.service;

import com.sparta.springschedule.entity.Memo;
import com.sparta.springschedule.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public List<Memo> getMemos() {
        return memoRepository.findAll();
    }

    public Memo getMemoById(Long id) {
        return memoRepository.findById(id).orElse(null);
    }

    public void createMemo(Memo memo) {
        memoRepository.save(memo);
    }

    public void updateMemo(Memo memo) {
        memoRepository.save(memo);
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
