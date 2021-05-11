package board;

public class Board {
	/* 게시글(카페 게시글, 뉴스, 공지사항 등)에 필요한 멤버변수를 선언하세요.
	 * -제목 내용? 작성자 작성시간 조회수 좋아요수 게시글 번호, 타입(말머리?)*/
	private int num, views, like;
	private String postTitle = "";
	private String contents = new String();
	private String writer = "";
	private String registerDate = "";
	private String type = "";
	
	
	//생성자를 만들어보세요 : 기본 생성자가 필요없음 정보가 있어야만 게시글이 등록가능하므로
	/*public Board(String w1) {
		writer = w1;
	}*/
	public Board(int num, String postTitle, String contents, String writer, String registerDate, String type) {
		this.num = num;
		this.postTitle = postTitle;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
	}
	/* 기능 : 게시글 정보 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음
	 * 메소드명 : print*/
	public void print() {
		System.out.println("번호 : "+num+'\n'+"제목 : "+ postTitle + '\n' + "작성자 : "+writer+'\n'+"조회수 : "+views+'\n'+"좋아요 : "+like+'\n' +"작성일 : "+registerDate + '\n' + "내용 : "+ contents);
	}
	
	
	//
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}





	

	

}
