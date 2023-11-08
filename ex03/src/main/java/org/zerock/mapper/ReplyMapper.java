package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read (Long id); // 특정 댓글 읽기
	public int delete(int id); // 특정 댓글 삭제
	public int update(ReplyVO reply);
}
