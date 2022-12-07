package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
//    @ModelAttribute("boardVO") @Valid boardVO;
    @Autowired
    BoardDAO boardDAO;

    @RequestMapping(value="/")
    public String home(){
        return "index";
    }
    @RequestMapping(value = "/board/posts", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("posts", boardDAO.getClassListList());
        return "board/posts";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public String addPost() {
        return "board/addpostform";
    }

    @RequestMapping(value = "/board/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVO vo) {
        int i = boardDAO.insertClassList(vo);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:posts";
    }

    @RequestMapping(value = "/board/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardDAO.getClassList(id);
        model.addAttribute("boardVO", boardVO);
        return "board/editform";
    }

    @RequestMapping(value = "/board/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        int i = boardDAO.updateClassList(vo);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:posts";
    }

    @RequestMapping(value = "/board/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id")int vo) {
        int i = boardDAO.deleteClassList(vo);
        if(i == 0)
            System.out.println("데이터 삭제 실패 ");
        else
            System.out.println("데이터 삭제 성공!!! ");
        return "redirect:../posts";
    }
}
