package me.salai.framework;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by salai on 21/10/16.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    // Main methdd
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    // Get the name of this application
    @Override
    public String getName(){
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){
        // What does I initialize?
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        // Register the Hello World resource over here. That is all I know as of now
        final HelloWorldResource resource = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(),
                helloWorldConfiguration.getDefaultName());
        environment.jersey().register(resource);

        // Registering the health check to the Application as well
        // Let's finally see how things get glued together,just get the hello world tutorial running
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(helloWorldConfiguration.getTemplate());
        environment.healthChecks().register("template", templateHealthCheck);
    }
}
