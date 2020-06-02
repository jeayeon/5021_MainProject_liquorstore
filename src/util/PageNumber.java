package util;

public class PageNumber {
	
	private int page;  // 현재 기준 페이지
	private int count;  // 총 글수
	private int start;  // 페이지그룹 시작 번호
	private int end;    // 페이지그룹 끝 번호
	private int nowPageStart;  //표시될 페이지 시작번호
	private int nowPageEnd;    //표시될 페이지 끝번호
	private int prev=0;;  //이전페이지그룹이있느냐
	private int next=0;   //이후 페이지 그룹이있느냐
	private int pageCnt=10; //페이지 그룹의 끝번호를 구할때필요한것(1~10번그룹 이후엔 11~20그룹)
	private int pagecnt=9; //한페이지당 1번~9번까지만 구하고싶어 만들어놓은 변수

	public Integer getPage() {
		return page;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPage(Integer page) {
		if (page < 1) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setCount(Integer count) {
		if (count < 1) {
			return;
		}
		this.count = count;
		System.out.println("총글수는? = " + count);
		calcPage();
	}

	public int getCount() {
		return count;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getPrev() {
		return prev;
	}

	public int getNext() {
		return next;
	}

	public int getNowPageStart() {
		return nowPageStart;
	}

	public int getNowPageEnd() {
		return nowPageEnd;
	}

	private void calcPage() {// page계산 메소드
							//math.ceil = 무조건 반올림하라
		int tempEnd = (int) (Math.ceil(page / (float)pageCnt) * pageCnt); // 페이지 그룹의 끝번호를 구하는 공식.

		System.out.println("this.count =" + this.count);
		// ���� ������ ��� 
		this.start = tempEnd - 9; 
		
		if(start > pageCnt) {
			prev=start-pageCnt;
		}
		
		if (tempEnd * pageCnt > this.count) { // 100개의글목록보다 토탈 글목록이 작다면
			this.end = (int) Math.ceil(this.count / (float)pagecnt);//만약 글이 45개다면 end는 5페이지
		} else {
			this.end = tempEnd; //10페이지 까지이고 next버튼을 누르면 11페이지로넘어간다.
			next=end+1;
		}
		
		nowPageStart = (page-1)*pagecnt+1; //현제페이지가 2라면 11 그 1번그룹에 페이지시작이 1~10이런순 
		nowPageEnd = nowPageStart + pagecnt - 1;//현재 페이지의 게시글 시작번호 11 +10 -1 하면 11~20 이런느낌
		if(nowPageEnd > this.count) {
			nowPageEnd=this.count;
		}
		
		
		System.out.println("page = " + page);
		System.out.println("start = " + start);
		System.out.println("this.end = " + this.end);
		System.out.println("nowpageStart= " + this.nowPageStart);
		System.out.println("nowpageEnd= " + this.nowPageEnd);
	}
	
}
