package com.example.mongoviewer.mongodb.utils;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MongoStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8778033599422329369L;

	private String serverUsed;

	private String ns;

	private Integer count;

	private Integer size;

	private Double avgObjSize;

	private Integer storageSize;

	private Integer numExtents;

	private Integer nindexes;

	private Integer lastExtentSize;

	private Double paddingFactor;

	private Integer systemFlags;

	private Integer userFlags;

	private Integer totalIndexSize;

	private Map<String, Integer> indexSizes;

	private Double ok;

	/**
	 * @return the serverUsed
	 */
	public String getServerUsed() {
		return serverUsed;
	}

	/**
	 * @param serverUsed the serverUsed to set
	 */
	public void setServerUsed(String serverUsed) {
		this.serverUsed = serverUsed;
	}

	/**
	 * @return the ns
	 */
	public String getNs() {
		return ns;
	}

	/**
	 * @param ns the ns to set
	 */
	public void setNs(String ns) {
		this.ns = ns;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the avgObjSize
	 */
	public Double getAvgObjSize() {
		return avgObjSize;
	}

	/**
	 * @param avgObjSize the avgObjSize to set
	 */
	public void setAvgObjSize(Double avgObjSize) {
		this.avgObjSize = avgObjSize;
	}

	/**
	 * @return the storageSize
	 */
	public Integer getStorageSize() {
		return storageSize;
	}

	/**
	 * @param storageSize the storageSize to set
	 */
	public void setStorageSize(Integer storageSize) {
		this.storageSize = storageSize;
	}

	/**
	 * @return the numExtents
	 */
	public Integer getNumExtents() {
		return numExtents;
	}

	/**
	 * @param numExtents the numExtents to set
	 */
	public void setNumExtents(Integer numExtents) {
		this.numExtents = numExtents;
	}

	/**
	 * @return the nindexes
	 */
	public Integer getNindexes() {
		return nindexes;
	}

	/**
	 * @param nindexes the nindexes to set
	 */
	public void setNindexes(Integer nindexes) {
		this.nindexes = nindexes;
	}

	/**
	 * @return the lastExtentSize
	 */
	public Integer getLastExtentSize() {
		return lastExtentSize;
	}

	/**
	 * @param lastExtentSize the lastExtentSize to set
	 */
	public void setLastExtentSize(Integer lastExtentSize) {
		this.lastExtentSize = lastExtentSize;
	}

	/**
	 * @return the paddingFactor
	 */
	public Double getPaddingFactor() {
		return paddingFactor;
	}

	/**
	 * @param paddingFactor the paddingFactor to set
	 */
	public void setPaddingFactor(Double paddingFactor) {
		this.paddingFactor = paddingFactor;
	}

	/**
	 * @return the systemFlags
	 */
	public Integer getSystemFlags() {
		return systemFlags;
	}

	/**
	 * @param systemFlags the systemFlags to set
	 */
	public void setSystemFlags(Integer systemFlags) {
		this.systemFlags = systemFlags;
	}

	/**
	 * @return the userFlags
	 */
	public Integer getUserFlags() {
		return userFlags;
	}

	/**
	 * @param userFlags the userFlags to set
	 */
	public void setUserFlags(Integer userFlags) {
		this.userFlags = userFlags;
	}

	/**
	 * @return the totalIndexSize
	 */
	public Integer getTotalIndexSize() {
		return totalIndexSize;
	}

	/**
	 * @param totalIndexSize the totalIndexSize to set
	 */
	public void setTotalIndexSize(Integer totalIndexSize) {
		this.totalIndexSize = totalIndexSize;
	}

	/**
	 * @return the indexSizes
	 */
	public Map<String, Integer> getIndexSizes() {
		return indexSizes;
	}

	/**
	 * @param indexSizes the indexSizes to set
	 */
	public void setIndexSizes(Map<String, Integer> indexSizes) {
		this.indexSizes = indexSizes;
	}

	/**
	 * @return the ok
	 */
	public Double getOk() {
		return ok;
	}

	/**
	 * @param ok the ok to set
	 */
	public void setOk(Double ok) {
		this.ok = ok;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
