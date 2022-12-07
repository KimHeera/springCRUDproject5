package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

    @RequestMapping(value="/")
    public String home(){
        return "index";
    }
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/posts", method = RequestMethod.GET)
    public String classlistlist(Model model) {
        model.addAttribute("posts", boardService.getClassListList());
        return"board/posts";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public String addPost() {
        return"board/addpostform";
    }

    @RequestMapping(value = "/board/addok", method = RequestMethod.POST)
    public String addPostOK(BoardVO vo) {
        int i = boardService.insertClassList(vo);
        if(i == 0)
            System.out.println("데이터 추가 실패 ");
        else
            System.out.println("데이터 추가 성공!!! ");
        return "redirect:posts";
    }

    @RequestMapping(value = "/board/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getClassList(id);
        model.addAttribute("boardVO", boardVO);
        return "board/editform";
    }
    @RequestMapping(value = "/board/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo) {
        int i = boardService.updateClassList(vo);
        if(i == 0)
            System.out.println("데이터 수정 실패 ");
        else
            System.out.println("데이터 수정 성공!!! ");
        return "redirect:posts";
    }
    @RequestMapping(value = "/board/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id")int vo) {
        int i = boardService.deleteClassList(vo);
        if(i == 0)
            System.out.println("데이터 삭제 실패 ");
        else
            System.out.println("데이터 삭제 성공!!! ");
        return "redirect:../posts";
    }
}