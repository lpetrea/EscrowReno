package org.deppar.viewer.spring;

import org.deppar.viewer.ViewerFactory;
import org.deppar.viewer.component.ImageNameViewerComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by mslpe on 25.09.2015.
 */
@Configuration
public class ViewerConfiguration {

    @Bean
    @Scope("prototype")
    public ViewerFactory viewerFactory() {

        return (name) -> new ImageNameViewer(imageNameViewerComponent(), name);
    }

    @Bean
    @Scope("prototype")
    public ImageNameViewerComponent imageNameViewerComponent() {

        return new ImageNameViewerComponent();
    }
}
