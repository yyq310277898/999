package cn.appsys.service.developer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.dao.appversion.AppVersionMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
@Service("AppInfoServiceImpl")
public class AppInfoServiceImpl implements AppinfoService {

	@Resource
	private AppInfoMapper appinfomapper;
	@Resource
	private AppVersionMapper appVersionMapper;

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<AppInfo> list = new ArrayList<>();
		list = appinfomapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
		return list;
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
					throws Exception {
		// TODO Auto-generated method stub
		return appinfomapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
	}
	@Override
	public boolean add(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(appinfomapper.add(appInfo)>0)
		{
			flag=true;
		}
		return flag;
	}
	public AppInfo getAppInfo(Integer id,String APKName) throws Exception {
		// TODO Auto-generated method stub
		return appinfomapper.getAppInfo(id,APKName);
	}
	@Override
	public boolean deleteAppInfoById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appinfomapper.deleteAppInfoById(delId) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean modify(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appinfomapper.modify(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAppLogo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(appinfomapper.deleteAppLogo(id) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfoObj) throws Exception {
		/*
		 * 上架： 
			1 更改status由【2 or 5】 to 4 ， 上架时间
			2 根据versionid 更新 publishStauts 为 2 

			下架：
			更改status 由4给为5
		 */

		Integer operator = appInfoObj.getModifyBy();
		if(operator < 0 || appInfoObj.getId() < 0 ){
			throw new Exception();
		}

		//get appinfo by appid
		AppInfo appInfo = appinfomapper.getAppInfo(appInfoObj.getId(), null);
		if(null == appInfo){
			return false;
		}else{
			switch (appInfo.getStatus()) {
			case 2: //当状态为审核通过时，可以进行上架操作
				onSale(appInfo,operator,4,2);
				break;
			case 5://当状态为下架时，可以进行上架操作
				onSale(appInfo,operator,4,2);
				break;
			case 4://当状态为上架时，可以进行下架操作
				offSale(appInfo,operator,5);
				break;

			default:
				return false;
			}
		}
		return true;
	}
	/**
	 * on Sale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @param versionStatus
	 * @throws Exception
	 */
	private void onSale(AppInfo appInfo,Integer operator,Integer appInfStatus,Integer versionStatus) throws Exception{
		offSale(appInfo,operator,appInfStatus);
		setSaleSwitchToAppVersion(appInfo,operator,versionStatus);
	}


	/**
	 * offSale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @return
	 * @throws Exception
	 */
	private boolean offSale(AppInfo appInfo,Integer operator,Integer appInfStatus) throws Exception{
		AppInfo _appInfo = new AppInfo();
		_appInfo.setId(appInfo.getId());
		_appInfo.setStatus(appInfStatus);
		_appInfo.setModifyBy(operator);
		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
		appinfomapper.modify(_appInfo);
		return true;
	}
	/**
	 * set sale method to on or off
	 * @param appInfo
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	private boolean setSaleSwitchToAppVersion(AppInfo appInfo,Integer operator,Integer saleStatus) throws Exception{
		AppVersion appVersion = new AppVersion();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		appVersionMapper.modify(appVersion);
		return false;
	}
}
