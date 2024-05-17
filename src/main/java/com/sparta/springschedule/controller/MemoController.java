package com.sparta.springschedule.controller;

import com.sparta.springschedule.entity.Memo;
import com.sparta.springschedule.service.MemoService;
import com.sparta.springschedule.util.DateTimeFormatterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/")
    public String index(Model model) {
        List<Memo> memos = memoService.getMemos();
        for (Memo memo : memos) {
            memo.setFormattedDate(DateTimeFormatterUtil.formatDate(memo.getDate()));
        }
        model.addAttribute("memos", memos);
        return "index";
    }

    @PostMapping("/memos")
    public String createMemo(Memo memo) {
        memoService.createMemo(memo);
        return "redirect:/";
    }

    @GetMapping("/memos/{id}")
    @ResponseBody
    public Memo getMemoById(@PathVariable Long id) {
        Memo memo = memoService.getMemoById(id);
        if (memo != null) {
            memo.setFormattedDate(DateTimeFormatterUtil.formatDate(memo.getDate()));
        }
        return memo;
    }

    @PostMapping("/memos/{id}/confirm")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> confirmPassword(@PathVariable Long id, @RequestParam String password) {
        boolean isPasswordCorrect = memoService.checkPassword(id, password);
        return ResponseEntity.ok(Map.of("success", isPasswordCorrect));
    }

    @PutMapping("/memos/{id}")
    @ResponseBody
    public ResponseEntity<Void> updateMemo(@PathVariable Long id, Memo memo) {
        memoService.updateMemo(id, memo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/memos/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return ResponseEntity.ok().build();
    }
}
