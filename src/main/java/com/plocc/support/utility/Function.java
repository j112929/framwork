/**
 * 宝龙电商
 * com.plocc.support.utility
 * Function.java
 *
 * 2013-8-29-下午12:07
 * 2013宝龙公司-版权所有
 *
 */
package com.plocc.support.utility;

import com.plocc.framework.utils.Md5Utility;

import java.util.*;

/**
 * Function
 *
 * @author Zhanggj
 * @version 1.0.0
 * @date 2013-8-29-下午12:07
 * @email zhanggj-hws@powerlong.com
 * @description 职责描述
 */
public class Function {

    /**
     * 获取 子命名空间 SpaceCode
     *
     * @param systemId
     * @param spaceCode
     * @return
     */
    public static String getSpaceCode(Long systemId, Long spaceCode) {
        return Md5Utility.getMD5String(systemId + "," + spaceCode);
    }

    /**
     * 获取 指定长度的 随机数
     *
     * @param length
     * @return
     */
    public static String randomByLength(int length) {
        String result = new String();
        for (int i = 0; i < length; i++) {
            result += (int) (Math.random() * 10);
        }
        return result;
    }

    /**
     * <b>功能：</b>返回一个List中随机项组成的List
     *
     * @param list   原始List
     * @param number 新List的大小
     * @return randomlist            随机生成的List
     */
    public static List getRandomList(List list, int number) {
        if (number < list.size()) {
            if (number < list.size() / 2) {
                List randomList = new ArrayList();
                int index;
                for (int i = 0; i < number; i++) {
                    index = (int) (Math.random() * (list.size() - 1));
                    randomList.add(list.get(index));
                    list.remove(index);
                }
                return randomList;
            } else {
                while (list.size() > number) {
                    int index = (int) (Math.random() * (list.size() - 1));
                    list.remove(index);
                }
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        Map values = new HashMap();
        while (true) {
            String value = getRandomList(new ArrayList( Arrays.asList("0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","))), 4).toString();
            if (values.containsKey(value)) {
                throw new Exception("第" + values.size() + "次重复啦，" + value);
            } else {
                values.put(value, value);
            }
        }
    }
}
