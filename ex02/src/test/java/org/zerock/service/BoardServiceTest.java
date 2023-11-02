package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import jdk.internal.org.jline.utils.Log;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void register() {
		BoardVO b = new BoardVO();
		b.setTitle("���� �ۼ��ϴ� ��2");
		b.setContent("new enwenw");
		b.setWriter("man2");
		
		service.register(b);
		
		log.info("������ �Խù� ��ȣ" + b.getId());
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
}
