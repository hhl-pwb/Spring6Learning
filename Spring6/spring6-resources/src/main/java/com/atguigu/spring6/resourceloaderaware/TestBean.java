package com.atguigu.spring6.resourceloaderaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class TestBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    /**
     * 实现ResourceLoaderAware接口必须实现的方法
     * 如果把该Bean部署在Spring容器中，该方法将会有Spring容器负责调用
     * Spring容器调用该方法是，Spring容器会将自身作为参数传给该方法
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
