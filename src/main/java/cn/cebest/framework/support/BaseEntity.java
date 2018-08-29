package cn.cebest.framework.support;

import java.io.Serializable;

/**
 * 
 * @author gaopeng@300.cn
 * @version 2018年8月29日 下午1:23:18
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -3208462242692788698L;

	/**
	 * 使所有Entity都拥有获取Repository的能力
	 * 
	 * @return IRepository
	 */
	//    public IRepository getRepository() {
	//        return AppContextUtility.getContext().getBean(IRepository.class);
	//    }
}
