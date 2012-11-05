/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.support.oauth.authentication.principal;

import org.jasig.cas.authentication.principal.AbstractPersonDirectoryCredentialsToPrincipalResolver;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.CredentialsToPrincipalResolver;

/**
 * This class resolves the principal id regarding the OAuth credentials : it's the typed user identifier.
 * 
 * @author Jerome Leleu
 * @since 3.5.0
 */
public final class OAuthCredentialsToPrincipalResolver extends AbstractPersonDirectoryCredentialsToPrincipalResolver
    implements CredentialsToPrincipalResolver {
    
    @Override
    protected String extractPrincipalId(final Credentials credentials) {
        final OAuthCredentials oauthCredentials = (OAuthCredentials) credentials;
        final String principalId = oauthCredentials.getUserProfile().getTypedId();
        log.debug("principalId : {}", principalId);
        return principalId;
    }
    
    /**
     * Return true if Credentials are OAuthCredentials, false otherwise.
     */
    @Override
    public boolean supports(final Credentials credentials) {
        return credentials != null && (OAuthCredentials.class.isAssignableFrom(credentials.getClass()));
    }
}
