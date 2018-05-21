package cn.appsys.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {
	//添加
	public int add(AppInfo appInfo) throws Exception;
	//验证APK名称是否存在
	public AppInfo getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName)throws Exception;
	//删除
	public int deleteAppInfoById(@Param(value="id")Integer delId)throws Exception;
	//修改
	public int modify(AppInfo appInfo)throws Exception;
	/**
	 * 根据appId，更新最新versionId
	 * @param versionId
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int updateVersionId(@Param(value="versionId")Integer versionId,@Param(value="id")Integer appId)throws Exception;

	//查询数据
	public List<AppInfo> getAppInfoList(@Param(value="softwareName")String querySoftwareName,
			@Param(value="status")Integer queryStatus,
			@Param(value="categoryLevel1")Integer queryCategoryLevel1,
			@Param(value="categoryLevel2")Integer queryCategoryLevel2,
			@Param(value="categoryLevel3")Integer queryCategoryLevel3,
			@Param(value="flatformId")Integer queryFlatformId,
			@Param(value="devId")Integer devId,
			@Param(value="from")Integer currentPageNo,
			@Param(value="pageSize")Integer pageSize)throws Exception;
	/**
	 * 总页数
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 * @throws Exception
	 */
	public int getAppInfoCount(@Param(value="softwareName")String querySoftwareName,
			@Param(value="status")Integer queryStatus,
			@Param(value="categoryLevel1")Integer queryCategoryLevel1,
			@Param(value="categoryLevel2")Integer queryCategoryLevel2,
			@Param(value="categoryLevel3")Integer queryCategoryLevel3,
			@Param(value="flatformId")Integer queryFlatformId,
			@Param(value="devId")Integer devId)throws Exception;
	//删除图片
	public int deleteAppLogo(@Param(value="id")Integer id)throws Exception;


	
	/**
	 * updateSaleStatusByAppId
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public int updateSaleStatusByAppId(@Param(value="id")Integer appId) throws Exception;

	/*
	 * 更新app状态
	 * @param status
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateSatus(@Param(value="status")Integer status,@Param(value="id")Integer id)throws Exception;

}
