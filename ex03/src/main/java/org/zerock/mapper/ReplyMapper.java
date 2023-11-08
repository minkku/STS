package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read (Long id); // Ư�� ��� �б�
	public int delete(int id); // Ư�� ��� ����
	public int update(ReplyVO reply);
}
