package com.speed.page;

import java.util.List;

public class PageModel {

	// 分页结果集
		private List<?> list;

		// 命中的总条数
		private long total;
		
		// 当前页
		private int currPage;
		
		// 每页显示的条目大小
		private int pageSize;
		
		// 总页数
		private int totalPages;
		
		// 上一页
		private int prevPage;
		
		// 下一页
		private int nextPage;
		
		public PageModel(List<?> list, long total, int pageSize, int currPage) {
			this.total = total;
			this.list = list;
			this.currPage = currPage <= 0 || currPage > Integer.MAX_VALUE ? 1 : currPage;
			this.pageSize = pageSize <= 0 || pageSize > Integer.MAX_VALUE ? 15 : pageSize;
			this.totalPages = (int) Math.ceil((float) total / pageSize);
			this.prevPage = (currPage - 1 < 1) ? 1 : currPage - 1;
			this.nextPage = (currPage + 1 > totalPages) ? totalPages : currPage + 1;
		}

		public List<?> getList() {
			return list;
		}

		public void setList(List<?> list) {
			this.list = list;
		}

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public int getCurrPage() {
			return currPage;
		}

		public void setCurrPage(int currPage) {
			this.currPage = currPage;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		public int getPrevPage() {
			return prevPage;
		}

		public void setPrevPage(int prevPage) {
			this.prevPage = prevPage;
		}

		public int getNextPage() {
			return nextPage;
		}

		public void setNextPage(int nextPage) {
			this.nextPage = nextPage;
		}

		@Override
		public String toString() {
			return "PageModel [list=" + list + ", total=" + total + ", currPage="
					+ currPage + ", pageSize=" + pageSize + ", totalPages="
					+ totalPages + ", prevPage=" + prevPage + ", nextPage="
					+ nextPage + "]";
		}
}
