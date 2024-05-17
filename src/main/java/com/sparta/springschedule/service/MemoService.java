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

    public boolean checkPassword(Long id, String password) {
        Memo memo = getMemoById(id);
        return memo != null && memo.getPassword().equals(password);
    }

    public void updateMemo(Long id, Memo updatedMemo) {
        Memo memo = getMemoById(id);
        if (memo != null) {
            memo.setTitle(updatedMemo.getTitle());
            memo.setContents(updatedMemo.getContents());
            memo.setUsername(updatedMemo.getUsername());
            memoRepository.save(memo);
        }
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}
