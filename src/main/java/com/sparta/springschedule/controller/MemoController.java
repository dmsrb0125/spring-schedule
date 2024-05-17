package com.sparta.springschedule.controller;

import com.sparta.springschedule.entity.Memo;
import com.sparta.springschedule.service.MemoService;
import com.sparta.springschedule.util.DateTimeFormatterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
