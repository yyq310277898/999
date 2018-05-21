package cn.appsys.service.developer;

import java.util.List;
import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	/**
	 * ����appId��ѯ��Ӧ��app�汾�б�
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionList(Integer appId)throws Exception;
	/**
	 * ����app�汾��Ϣ��������app_info���versionId�ֶ�
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean appsysadd(AppVersion appVersion)throws Exception;
	/**
	 * ����id��ȡAppVersion
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(Integer id)throws Exception;
	
	/**
	 * �޸�app�汾��Ϣ
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppVersion appVersion)throws Exception;
	
	/**
	 * ɾ��apk�ļ�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteApkFile(Integer id)throws Exception;
}
