package com.example.mongoviewer.controller.pagination;

import java.util.ArrayList;
import java.util.List;

public class Paging {

	public static final int PAGE_LIMIT = 20;

	/**
	 * 全件
	 */
	private long totalCount;
	/**
	 * 検索条件に一致した件数
	 */
	private long resultCount;
	/**
	 * ページ位置
	 */
	private int numberOfCurrentPage;
	/**
	 * 表示開始位置
	 */
	private long showingFrom;
	/**
	 * 表示終了位置
	 */
	private long showingTo;

	private String url;
	private String queryString;

	private List<PageBean> pageList;

	private String leftArrow;
	private String rightArrow;

	public Paging(long totalCount, long resultCount, int numberOfCurrentPage, String url, String queryString) {
		super();
		this.totalCount = totalCount;
		this.resultCount = resultCount;
		this.numberOfCurrentPage = numberOfCurrentPage;
		this.url = url;
		this.queryString = queryString;
	}

	public void makePageList() {

		pageList = new ArrayList<>();

		int numberOfPages = calcNumberOfPages();

		//page from to
		//1    1    10
		//2    11   20
		//3    21   30
		showingFrom = (numberOfCurrentPage - 1) * Paging.PAGE_LIMIT + 1;

		showingTo = (numberOfCurrentPage * Paging.PAGE_LIMIT);
		if (showingTo > resultCount) {
			showingTo = resultCount;
		}

		//現在の表示位置が1ページ目でなければ前頁のlink
		if (numberOfCurrentPage != 1) {
			leftArrow = url + Integer.valueOf(numberOfCurrentPage-1).toString();
			if (queryString != null) {
				leftArrow += parseQueryString();
			}
		} else {
			leftArrow = null;
		}

		//現在の表示位置が最後のページでなければ次ページのlink
		if (numberOfCurrentPage != numberOfPages) {
			rightArrow = url + Integer.valueOf(numberOfCurrentPage + 1).toString();
			if (queryString != null) {
				rightArrow += parseQueryString();
			}
		} else {
			rightArrow = null;
		}

		for (int i=0; i<numberOfPages; i++) {

			int page = i+1;

			String req = url + Integer.valueOf(page).toString();
			if (queryString != null) {
				req += parseQueryString();
			}

			boolean disable = false;
			if (i == numberOfCurrentPage-1) {
				disable = true;
			}

			PageBean p = new PageBean(Integer.toString(page), req, disable);
			pageList.add(p);

		}

	}

	/**
	 * ページ数の計算
	 * 
	 * @return
	 */
	private int calcNumberOfPages() {
		int numberOfPages = (int)resultCount / Paging.PAGE_LIMIT;
		if ((int)resultCount % Paging.PAGE_LIMIT > 0) {
			numberOfPages += 1;
		}
		return numberOfPages;
	}

	private String parseQueryString() {
		if (queryString == null || queryString.length() == 0) {
			return "";
		}

		String params[] = queryString.split("&");

		if (params != null && params.length > 0) {

			boolean hit = false;

			for (String param : params) {
				String kv[] = param.split("=");
				if (kv != null && kv.length == 2) {
					if (kv[1] != null && kv[1].length() > 0) {
						hit = true;
						break;
					}
				}
			}

			if (hit) {
				return "?" + queryString;
			}

		}

		return "";

	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the resultCount
	 */
	public long getResultCount() {
		return resultCount;
	}

	/**
	 * @param resultCount the resultCount to set
	 */
	public void setResultCount(long resultCount) {
		this.resultCount = resultCount;
	}

	/**
	 * @return the numberOfCurrentPage
	 */
	public int getNumberOfCurrentPage() {
		return numberOfCurrentPage;
	}

	/**
	 * @param numberOfCurrentPage the numberOfCurrentPage to set
	 */
	public void setNumberOfCurrentPage(int numberOfCurrentPage) {
		this.numberOfCurrentPage = numberOfCurrentPage;
	}

	/**
	 * @return the showingFrom
	 */
	public long getShowingFrom() {
		return showingFrom;
	}

	/**
	 * @param showingFrom the showingFrom to set
	 */
	public void setShowingFrom(int showingFrom) {
		this.showingFrom = showingFrom;
	}

	/**
	 * @return the showingTo
	 */
	public long getShowingTo() {
		return showingTo;
	}

	/**
	 * @param showingTo the showingTo to set
	 */
	public void setShowingTo(int showingTo) {
		this.showingTo = showingTo;
	}

	/**
	 * @return the pageList
	 */
	public List<PageBean> getPageList() {
		return pageList;
	}

	/**
	 * @param pageList the pageList to set
	 */
	public void setPageList(List<PageBean> pageList) {
		this.pageList = pageList;
	}

	/**
	 * @return the leftArrow
	 */
	public String getLeftArrow() {
		return leftArrow;
	}

	/**
	 * @param leftArrow the leftArrow to set
	 */
	public void setLeftArrow(String leftArrow) {
		this.leftArrow = leftArrow;
	}

	/**
	 * @return the rightArrow
	 */
	public String getRightArrow() {
		return rightArrow;
	}

	/**
	 * @param rightArrow the rightArrow to set
	 */
	public void setRightArrow(String rightArrow) {
		this.rightArrow = rightArrow;
	}

}
