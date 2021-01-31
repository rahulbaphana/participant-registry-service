package com.participant.registry;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class TestContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static volatile boolean started = false;

    private DockerComposeContainer container;

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!isEnabled(applicationContext)) {
            return;
        }

        if (started) {
            log.info("Testcontainer already started");
            return;
        }

        try {
            startComposeTestContainer();
            started = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerCleanupListener(applicationContext);
    }

    private boolean isEnabled(ConfigurableApplicationContext applicationContext) {
        String testContainersEnabled = (String) applicationContext
            .getEnvironment()
            .getSystemEnvironment()
            .getOrDefault("ENV_TEST_CONTAINERS_ENABLED", "true");

        log.info("Testcontainers enabled: {}", testContainersEnabled);
        return Boolean.valueOf(testContainersEnabled);
    }

    private void startComposeTestContainer()
        throws IOException, InterruptedException {
        Path tempDirectory = Files.createTempDirectory("shortly-platform");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        org.springframework.core.io.Resource[] resources = resolver.getResources("testcontainers/**/*");
        for (org.springframework.core.io.Resource resource : resources) {
            try (OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(tempDirectory.toFile(), resource.getFilename())))) {
                IOUtils.copy(new BufferedInputStream(resource.getInputStream()), os);
            }
        }
        container = new DockerComposeContainer(new File(tempDirectory.toFile(), "testcontainer-compose.yml"));
        log.info("Container starting");
        container.start();
        Thread.sleep(2000L);

    }

    private void registerCleanupListener(ConfigurableApplicationContext applicationContext) {
        applicationContext.addApplicationListener((ApplicationListener<ContextClosedEvent>) event -> {
            if (container == null) {
                return;
            }
            try {
                container.stop();
            } catch (Exception e) {
            }
        });
    }
}

