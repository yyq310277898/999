package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.AppCategory;


public interface AppCategoryService {
	/**
	 * ���ݸ��ڵ�parentId��ȡ��Ӧ�ķ����б�
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
