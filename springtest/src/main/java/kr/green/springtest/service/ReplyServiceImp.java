package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.stereotype.*;

import kr.green.springtest.dao.ReplyDAO;
import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
 /* 서비스 임플에서 서비스 어노테이션을 지우고 재가동 하면 500번 에러가 남 
  * 
  * */
	private ReplyDAO replyDao;

	@Override
	public int insertReply(ReplyVO rvo) {
		if(rvo.getRp_me_id() == null || rvo.getRp_me_id().length() == 0)
			return 0;
		replyDao.insertReply(rvo);
		return 1;
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(int num, Criteria cri) {
		return replyDao.getReplyList(num, cri);
		
	}

	@Override
	public int getTotalCount(int num) {
		
		return replyDao.getTotalCount(num);
	}
	
}
