package springweb.d01_board.vo;

public class Board_Sch {
// page처리..
	private int count; // �ѰǼ�
	private int pageSize; // ���������� ������ ������ �Ǽ� 
	private int pageCount; // �� ������ ��
	private int curPage; // Ŭ���� ���� page ��ȣ
	private int start; // �ش� �������� ���۹�ȣ
	private int end;  // �ش� �������� ��������ȣ
	
// 검색 내용
	private String subject;
	private String writer;
	private String content;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
