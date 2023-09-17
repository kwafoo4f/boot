package cn.zk.springboot.autoconfiguration;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 使用SPI方式扫描AutoConfiguration实现类,进行自动装配
 */
public class ZkImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // SPI
        ServiceLoader<AutoConfiguration> autoConfigurationImplList =
                ServiceLoader.load(AutoConfiguration.class);

        List<String> names = new ArrayList<>();
        Iterator<AutoConfiguration> iterator = autoConfigurationImplList.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next().getClass().getName();
            names.add(name);
        }

        System.out.println("自动配置加载==》"+names);
        // 获取所有实现类的名称
        return names.toArray(new String[0]);
    }
}
