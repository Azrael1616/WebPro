package cs.dit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cs.dit.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	@Select("select * from tbl_board")
	public List<BoardVO> getList2();
	
	public int insert(BoardVO board);
	
	public BoardVO selectOne(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);

}