package com.adley.oauth.resource.config;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Oauth2GlobalMethodConfig extends GlobalMethodSecurityConfiguration {
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
