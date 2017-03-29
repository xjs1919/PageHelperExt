package com.github.xjs.mybatis.pagehelper.ext;

import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

import com.github.pagehelper.PageInfo;

/**
 * Created by xujiashuai on 2016/6/29.
 */
public class PageObjectWrapper implements ObjectWrapper {

    @SuppressWarnings("rawtypes")
	private PageInfo pageinfo;

    @SuppressWarnings("rawtypes")
	public PageObjectWrapper(PageInfo wrapped){
        this.pageinfo = wrapped;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public <E> void addAll(List<E> element) {
        com.github.pagehelper.Page page = (com.github.pagehelper.Page) element;
        pageinfo.setPageNum(page.getPageNum());
        pageinfo.setPageSize(page.getPageSize());
        pageinfo.setOrderBy(page.getOrderBy());
        pageinfo.setPages(page.getPages());
        pageinfo.setList(page);
        pageinfo.setSize(page.size());
        pageinfo.setTotal(page.getTotal());
        if (page.size() == 0) {
        	pageinfo.setStartRow(0);
        	pageinfo.setEndRow(0);
        } else {
        	pageinfo.setStartRow(page.getStartRow() + 1);
        	pageinfo.setEndRow(pageinfo.getStartRow() - 1 + pageinfo.getSize());
        }
        pageinfo.setNavigatePages(8);
        calcNavigatepageNums(pageinfo, page);
        calcPage(pageinfo);
        judgePageBoudary(pageinfo);
    }
    
    @SuppressWarnings("rawtypes")
	private void calcNavigatepageNums(PageInfo pageinfo, com.github.pagehelper.Page page) {
        int pages = pageinfo.getPages();
        int navigatePages = pageinfo.getNavigatePages();
        int pageNum = pageinfo.getPageNum();
        int[] navigatepageNums = null;
        if (pages <= navigatePages) {
        	navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { 
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        pageinfo.setNavigatepageNums(navigatepageNums);
    }

    @SuppressWarnings("rawtypes")
	private void calcPage(PageInfo pageinfo) {
    	int[] navigatepageNums = pageinfo.getNavigatepageNums();
    	int pageNum = pageinfo.getPageNum();
        if (navigatepageNums != null && navigatepageNums.length > 0) {
        	pageinfo.setFirstPage(navigatepageNums[0]);
        	pageinfo.setLastPage(navigatepageNums[navigatepageNums.length - 1]);
            if (pageNum > 1) {
            	pageinfo.setPrePage(pageNum - 1);
            }
            if (pageNum < pageinfo.getPages()) {
            	pageinfo.setNextPage(pageNum + 1);
            }
        }
    }

    @SuppressWarnings("rawtypes")
	private void judgePageBoudary(PageInfo pageinfo) {
    	int pageNum = pageinfo.getPageNum();
    	int pages = pageinfo.getPages();
    	pageinfo.setIsFirstPage(pageNum == 1);
    	pageinfo.setIsLastPage(pageNum == pages);
    	pageinfo.setHasPreviousPage(pageNum > 1);
    	pageinfo.setHasNextPage(pageNum < pages);
    }

    @Override
    public Object get(PropertyTokenizer prop) {
        return null;
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {

    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return null;
    }

    @Override
    public String[] getGetterNames() {
        return new String[0];
    }

    @Override
    public String[] getSetterNames() {
        return new String[0];
    }

    @Override
    public Class<?> getSetterType(String name) {
        return null;
    }

    @Override
    public Class<?> getGetterType(String name) {
        return null;
    }

    @Override
    public boolean hasSetter(String name) {
        return false;
    }

    @Override
    public boolean hasGetter(String name) {
        return false;
    }

    @Override
    public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
        return null;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public void add(Object element) {

    }
}
