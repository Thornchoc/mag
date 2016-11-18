package com.thorntons.guice;

import com.google.inject.AbstractModule;
import com.thorntons.context.ScenarioContext;
import cucumber.api.guice.CucumberScopes;

public final class ProjectModule extends AbstractModule {
    @Override
    public void configure() {
        try {
            
            // Bindings for classes that are shared for the lifetime of the
            // scenario.
            bind(ScenarioContext.class).in(CucumberScopes.SCENARIO);
        } catch (Exception e) {
            addError(e.getMessage());
        }
    }
}
