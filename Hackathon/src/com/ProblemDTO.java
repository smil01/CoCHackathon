package com;

public class ProblemDTO {
	private int num;
	private String content;
	private String writer;
	private String machine;
	private String gps;
	private String addr;
	private String time;
	private String src;
	private int state;

	public ProblemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProblemDTO(int num, String content, String writer, String machine, String gps, String addr, String time,
			String src, int state) {
		super();
		this.num = num;
		this.content = content;
		this.writer = writer;
		this.machine = machine;
		this.gps = gps;
		this.addr = addr;
		this.time = time;
		this.src = src;
		this.state = state;
	}

	public ProblemDTO(String content, String writer, String machine, String gps, String addr, String time, String src) {
		super();
		this.content = content;
		this.writer = writer;
		this.machine = machine;
		this.gps = gps;
		this.addr = addr;
		this.time = time;
		this.src = src;
	}

	public ProblemDTO(int num, String content, String writer, String gps, String addr, String time, int state) {
		super();
		this.num = num;
		this.content = content;
		this.writer = writer;
		this.gps = gps;
		this.addr = addr;
		this.time = time;
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getX() {
		if (gps != null)
			return gps.substring(0, gps.indexOf(','));
		return null;
	}

	public String getY() {
		if (gps != null)
			return gps.substring(gps.indexOf(',') + 1, gps.length() - 1);
		return null;
	}

	@Override
	public String toString() {
		String result = "";
		result += "{\"num\" : \"" + num + "\",";
		result += "\"content\" : \"" + content + "\",";
		result += "\"writer\" : \"" + writer + "\",";
		result += "\"machine\" : \"" + machine + "\",";
		result += "\"gps\" : \"" + gps + "\",";
		result += "\"addr\" : \"" + addr + "\",";
		result += "\"time\" : \"" + time + "\",";
		result += "\"src\" : \"" + src + "\",";
		result += "\"state\" : \"" + state + "\"}";
		return result;
	}

}
