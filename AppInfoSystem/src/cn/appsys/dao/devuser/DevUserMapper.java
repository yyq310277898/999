package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	public DevUser getLoginUser(@Param("devCode")String devCode);
	//����Dev��ȡ�û���¼
}
