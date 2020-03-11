package cn.jeff.study.dubbodemoconsumer;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.cluster.ConfiguratorFactory;
import org.junit.Test;

/**
 * @author swzhang
 * @date 2020/03/02
 */
public class AdaptiveTests {

    @Test
    public void testAdaptive() {
        ConfiguratorFactory configuratorFactory = ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class)
                .getAdaptiveExtension();
    }
}
