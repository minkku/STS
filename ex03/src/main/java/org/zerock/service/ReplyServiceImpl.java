package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor

public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper mapper;

	@Override
	public int resgister(ReplyVO vo) {
		log.info(vo);

		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long id) {
		return mapper.read(id);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(int id) {
		return mapper.delete(id);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long id) {
		return mapper.getListWithPaging(cri, id);
	}
}
