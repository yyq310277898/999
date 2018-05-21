package cn.appsys.dao.appversion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {
	//查询数据到版本信息页面
	public List<AppVersion> getAppVersionList(@Param("appId")Integer appId) throws Exception;
	
	public int add(AppVersion appVersion)throws Exception;
	
	public int getVersionCountByAppId(@Param("appId")Integer appId)throws Exception;
	//
	public int deleteVersionByAppId(@Param("appId")Integer appId)throws Exception;
	
	public AppVersion getAppVersionById(@Param("id")Integer id)throws Exception;
	
	public int modify(AppVersion appVersion)throws Exception;
	//删除apk文件
	public int deleteApkFile(@Param("id")Integer id)throws Exception;
	
	
}
