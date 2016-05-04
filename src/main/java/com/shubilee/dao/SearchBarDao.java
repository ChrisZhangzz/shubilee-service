
package com.shubilee.dao;

import java.util.List;

import com.shubilee.entity.SearchBar;

public interface SearchBarDao {    
	public SearchBar selectSearchBar();
	public List<SearchBar> selectAllSearchBar();
}