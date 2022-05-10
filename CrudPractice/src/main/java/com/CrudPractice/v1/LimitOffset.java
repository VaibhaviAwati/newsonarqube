package com.CrudPractice.v1;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class LimitOffset implements Pageable {
 private int  limit;
 private int offset;
 private String sortBy;
 
 public  LimitOffset(int limit,int offset,String sortBy)
 {
	 this.limit=limit;
	 this.offset=offset;
	 this.sortBy=sortBy;
	 
 }
@Override
public int getPageNumber() {
	// TODO Auto-generated method stub
	return 1;
}

@Override
public int getPageSize() {
	// TODO Auto-generated method stub
	return this.limit;
}

@Override
public long getOffset() {
	// TODO Auto-generated method stub
	return this.offset;
}

@Override
public Sort getSort() {
	// TODO Auto-generated method stub
	return Sort.by(this.sortBy).ascending();
}

@Override
public Pageable next() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Pageable previousOrFirst() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Pageable first() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Pageable withPage(int pageNumber) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean hasPrevious() {
	// TODO Auto-generated method stub
	return false;
}
 
}
