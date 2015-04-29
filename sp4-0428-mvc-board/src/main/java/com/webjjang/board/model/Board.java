package com.webjjang.board.model;

import java.util.List;

/*
 *  게시판의 데이터를 저장해서 전달해 주는 Model이다.
 */
public class Board {
	private int rnum,no,target,fileCount;
	private String title,content,writer, wdate;
	private List<AttachedFile> fileList;
	// 공통 데이터 생성자
	public Board(int no, String title,
			String writer, String wdate, int target, int fileCount) {
		this.no = no;
		this.target = target;
		this.fileCount = fileCount;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
	}
	// List용 데이터 생성자
	public Board(int rnum, int no, String title,
			String writer, String wdate, int target, int fileCount) {
		this(no, title, writer, wdate, target, fileCount);
		this.rnum = rnum;
	}

	// View용 데이터 생성자
	public Board(int no, String title,
			String content, String writer, String wdate,
			int target, int fileCount) {
		this(no, title, writer, wdate, target, fileCount);
		this.content = content;
	}
	// 기본생성자
	public Board(){}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public List<AttachedFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<AttachedFile> fileList) {
		this.fileList = fileList;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	@Override
	public String toString() {
		return "Board [rnum=" + rnum + ", no=" + no + ", target=" + target
				+ ", fileCount=" + fileCount + ", title=" + title
				+ ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + ", fileList=" + fileList + "]";
	}
}
