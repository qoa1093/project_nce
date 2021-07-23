package kr.green.springtest.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("rvo") ReplyVO rvo);// 파람을 안쓰면 rvo.~로 안써도 되지만 헷갈릴까봐 사용

}
