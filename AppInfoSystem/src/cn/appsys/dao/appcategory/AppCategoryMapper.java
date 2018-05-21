package cn.appsys.dao.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;


public interface AppCategoryMapper {
	//查询一二三级列表的方法
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId)throws Exception;
}
