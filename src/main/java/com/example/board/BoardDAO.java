package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate template;
//    Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    private final String CLASSLIST_INSERT = "insert into CLASSLIST (titleName, professor, section, credits, type, classTime, category, english) values (?,?,?,?,?,?,?,?)";
    private final String CLASSLIST_UPDATE = "update CLASSLIST set titleName=?, professor=?, section=?, credits=?, type=?, classTime=?, category=?, english=?  where seq=?";
    private final String CLASSLIST_DELETE = "delete from CLASSLIST  where seq=?";
    private final String CLASSLIST_GET = "select * from CLASSLIST where seq=?";
    private final String CLASSLIST_LIST = "select * from CLASSLIST order by seq desc";

    public int insertClassList(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        return template.update(CLASSLIST_INSERT, new Object[]{vo.getTitleName(), vo.getProfessor(), vo.getSection(), vo.getCredits(), vo.getType(), vo.getClassTime(), vo.getCategory(), vo.getEnglish()});
    }

    // 글 삭제
    public int deleteClassList(int id) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        return template.update(CLASSLIST_DELETE, id);
    }

    public int updateClassList(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        return template.update(CLASSLIST_UPDATE, new Object[]{vo.getTitleName(), vo.getProfessor(), vo.getSection(), vo.getCredits(), vo.getType(), vo.getClassTime(), vo.getCategory(), vo.getEnglish(), vo.getSeq()});
    }

    public BoardVO getClassList(int seq) {
        return template.queryForObject(CLASSLIST_GET, new Object[] {seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getClassListList() {
        return template.query(CLASSLIST_LIST, new BoardRowMapper());
    }


        class BoardRowMapper implements RowMapper<BoardVO> {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO one = new BoardVO();
                one.setSeq(rs.getInt("seq"));
                one.setTitleName(rs.getString("titleName"));
                one.setProfessor(rs.getString("professor"));
                one.setSection(rs.getInt("section"));
                one.setCredits(rs.getFloat("credits"));
                one.setType(rs.getString("type"));
                one.setClassTime(rs.getString("classTime"));
                one.setCategory(rs.getString("category"));
                one.setEnglish(rs.getInt("english"));
                return one;
            }
        }
}
