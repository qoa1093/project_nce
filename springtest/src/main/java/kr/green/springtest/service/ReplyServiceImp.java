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

	@Override
	public String updateReply(ReplyVO reply) {
		if(reply == null || reply.getRp_num() <= 0 || reply.getRp_me_id() == null
				|| reply.getRp_me_id().length() == 0)
			return "FAIL";
		ReplyVO dbReply = replyDao.getReply(reply.getRp_num()); //기존 댓글을 가져옴
		//System.out.println(dbReply);
		if(!reply.getRp_me_id().equals(dbReply.getRp_me_id()))
			return "FAIL";
		dbReply.setRp_content(reply.getRp_content());
		return replyDao.updateReply(dbReply) == 1 ? "SUCCESS" : "FAIL";
		
	}

	@Override
	public String deleteReply(ReplyVO reply) {
		if(reply == null || reply.getRp_num() <= 0 || reply.getRp_me_id() == null
				|| reply.getRp_me_id().length() == 0)
			return "FAIL";
		ReplyVO dbReply = replyDao.getReply(reply.getRp_num()); //기존 댓글을 가져옴
		//System.out.println(dbReply);
		if(!reply.getRp_me_id().equals(dbReply.getRp_me_id()))
			return "FAIL";
		dbReply.setRp_valid("D");
		return replyDao.updateReply(dbReply) == 1 ? "SUCCESS" : "FAIL";
	}
	
}
