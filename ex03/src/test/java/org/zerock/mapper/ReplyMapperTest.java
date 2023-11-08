package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	// DB안에 존재하는 id 확인하기
	private Long[] idArr = { 1L, 3L, 4L, 5L, 6L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();

			vo.setTb1_board_id(idArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Long targetId = 3L;
		
		ReplyVO vo = mapper.read(targetId);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int targetId = 3;
		
		mapper.delete(targetId);
	}
	
	@Test
	public void testUpdate() {
		Long targetId = 4L;
		
		ReplyVO vo = mapper.read(targetId);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : " + count);
	}
}
