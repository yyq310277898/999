package cn.appsys.service.developer;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppinfoService {
	/**
	 * 根据条件查询出app列表
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
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
	 * 根据条件查询appInfo表记录数
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

	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean add(AppInfo appInfo) throws Exception;
	/**
	 * 根据id、apkName查找appInfo
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppInfo getAppInfo(Integer id,String APKName)throws Exception;

	/**
	 * 根据appId删除app应用
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppInfoById(Integer delId)throws Exception;
	/**
	 * 修改app信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppInfo appInfo)throws Exception;

	/**
	 * 删除logo图片
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppLogo(Integer id)throws Exception;

	/**
	 * update Sale Status By AppId and Operator
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception;
}
