package com.webjjang.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.webjjang.board.model.Board;

public class BoardDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int selectCount(String[] searchKeyArr, String searchWord) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from board ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<Board> list(int startRow, int endRow,
			String[] searchKeyArr,
			String searchWord) {
		// TODO Auto-generated method stub
		//sql 작성
		// board의 내용의 리스트해당항목을 글번호 desc
		String sql=" select no,title,writer, "
		+" to_char(wdate,'yyyy-mm-dd') wdate, "
		+" target, fileCount from board "
//		+searchStr
		+" order by no desc ";
		// rownum을 붙인다.
		sql=" select rownum rnum,no,title,writer, "
		+ " wdate, target, fileCount "
		+ " from ("+sql+") ";
		// rnum중에서 startRow,endRow를 적용시킨다.:where
		sql=" select * from ("+sql+") "
		+ " where rnum between ? and ? ";
		
		System.out.println(sql);
		
		return jdbcTemplate.query(sql,
			new RowMapper<Board>(){
				public Board mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					// TODO Auto-generated method stub
					Board board = new Board(
						rs.getInt("rnum"),
						rs.getInt("no"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("wdate"),
						rs.getInt("target"),
						rs.getInt("fileCount"));
					return board;
				}// end of mapRow
			} // RowMapper 생성자 끝
		,startRow, endRow
		);
	}
	

}
