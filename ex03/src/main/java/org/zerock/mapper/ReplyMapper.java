package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read (Long id); // Ư�� ��� �б�
	public int delete(int id); // Ư�� ��� ����
	public int update(ReplyVO reply);
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("id") Long id);
}
