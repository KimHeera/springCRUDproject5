package com.example.board;

import java.util.List;

public interface BoardService {
    public int insertClassList(BoardVO vo);
    public int deleteClassList(int seq);
    public int updateClassList(BoardVO vo);
    public BoardVO getClassList(int seq);
    public List<BoardVO> getClassListList();
}
