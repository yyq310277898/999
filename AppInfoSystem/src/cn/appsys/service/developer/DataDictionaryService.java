package cn.appsys.service.developer;

import java.util.List;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {
	
	/**
	 * ����typeCode��ѯ��Ӧ�������ֵ��б�
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> getDataDictionaryList(String typeCode)throws Exception;
}
