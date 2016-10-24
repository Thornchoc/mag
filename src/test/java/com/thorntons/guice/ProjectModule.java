package com.thorntons.guice;

import com.google.inject.AbstractModule;
import com.thorntons.context.ThorntonsContext;
import com.thorntons.pages.HomePage;
import cucumber.api.guice.CucumberScopes;

public final class ProjectModule extends AbstractModule {
    @Override
    public void configure() {
        try {
            
            // Bindings for classes that are shared for the lifetime of the
            // scenario.
            bind(ThorntonsContext.class).in(CucumberScopes.SCENARIO);
        } catch (Exception e) {
            addError(e.getMessage());
        }
    }
}
