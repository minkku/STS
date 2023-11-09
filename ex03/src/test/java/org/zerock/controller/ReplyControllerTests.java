package org.zerock.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyControllerTests {
	
	@Setter(onMethod_ = {@Autowired})
	private ReplyService sv;
	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setTb1_board_id(6L);
		vo.setReply("DKANASDKF");
		vo.setReplyer("asdfasd");
		log.info(sv.resgister(vo));
	}
	
	@Test
	public void testSearch() {
		ReplyVO vo = new ReplyVO();
		vo.setId(4L);
		log.info(sv.get(4L));
	}
	
	@Test
	public void testModify() {
		ReplyVO vo = new ReplyVO();
		vo.setId(1L);
		vo.setReply("댓글 수정해유");
		vo.setReplyer("작성자두유");
		
		log.info(sv.modify(vo));
	}
}
