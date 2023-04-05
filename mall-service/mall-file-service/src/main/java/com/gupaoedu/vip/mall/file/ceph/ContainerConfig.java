package com.gupaoedu.vip.mall.file.ceph;

import lombok.Data;
import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author ErenPC
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "ceph")
@Data
public class ContainerConfig {

    private String username;
    private String password;
    private String authUrl;
    private String defaultContainerName;

    /**
     * ceph的账号配置信息
     */
    @Bean
    public Account account() {
        AccountConfig config = new AccountConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setAuthUrl(authUrl);
        config.setAuthenticationMethod(AuthenticationMethod.BASIC);
        return new AccountFactory(config).createAccount();
    }

    /**
     * 容器对象
     */
    @Bean
    public Container container() {
        Container container = account().getContainer(defaultContainerName);
        if (!container.exists()) {
            return container.create();
        }
        return container;
    }

}
