package cn.cebest.framework.util;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * @author gaopeng@300.cn
 * @version 2018年8月29日 下午1:07:26
 */
public class FileUtility extends FileUtils {

	protected static final Log log = LogFactory.getLog(FileUtility.class);

	public static Resource[] getResources(String locationPattern) {
		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = new Resource[0];
		try {
			resources = patternResolver.getResources(locationPattern);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return resources;
	}
}
