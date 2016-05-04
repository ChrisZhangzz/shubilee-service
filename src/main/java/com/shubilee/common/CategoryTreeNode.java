package com.shubilee.common;

import java.util.List;


public class CategoryTreeNode {
	
	private int cat_id;
	
    private String cat_name;
    
    private String cat_ename;
    
    private int parent_id;
    
	private String icon;
	
    public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
  
    public List<CategoryTreeNode> children;
    
	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_ename() {
		return cat_ename;
	}

	public void setCat_ename(String cat_ename) {
		this.cat_ename = cat_ename;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
       
}