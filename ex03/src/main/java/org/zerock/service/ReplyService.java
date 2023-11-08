package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	public int resgister(ReplyVO vo);
	public ReplyVO get(Long id);
	public int modify(ReplyVO vo);
	public int remove(int id);
	public List<ReplyVO> getList(Criteria cri, Long id);
}
