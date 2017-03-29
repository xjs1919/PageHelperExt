/**
 * 
 */
package com.github.xjs.mybatis.handler.domain;

import java.io.Serializable;

/**
 * @author 605162215@qq.com
 *
 * 2016年7月1日 上午9:09:19
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pageNum;
	private int pageSize;
	//private boolean count = true;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
//	public boolean getCount() {
//		return count;
//	}
//	public void setCount(boolean count) {
//		this.count = count;
//	}
	
}
