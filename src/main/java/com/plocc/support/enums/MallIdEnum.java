package com.plocc.support.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * AddressEnum
 * 收货地址枚举类
 * 刘博宇
 * 2013-7-19-下午03:59:29
 * 
 * @version 1.0.0
 * 
 */
public enum MallIdEnum {
	MALL_FUZHOU("1","福州"),
	MALL_JINJIANG("2","晋江");
	public String key;
	public String value;
	
	private MallIdEnum(String key,String value) {
		this.key = key;
		this.value = value;
	}
	
	public static String getValueByKey(String key){
		return MallIdEnum.getMap().get(key);
	}
	
	public static Map<String ,String> getMap() { 
		Map<String ,String> map = new HashMap<String ,String>();
		for (MallIdEnum s : MallIdEnum.values())  {
			map.put(s.key, s.value);
	    }
		return map;  
	}

	public static List getMalls() { 
		List<Map> malls = new ArrayList<Map>();
		for (MallIdEnum s : MallIdEnum.values())  {
			Map<String ,String> map = new HashMap<String ,String>();
			map.put("mall", s.key);
			map.put("name", s.value);
			malls.add(map);
	    }
		return malls;  
	}
	
	public static List<String> getMallIds(){
		List<String> rtn = new ArrayList<String>();
		rtn.add(MALL_FUZHOU.key);
		rtn.add(MALL_JINJIANG.key);
		return rtn;
	}
}
