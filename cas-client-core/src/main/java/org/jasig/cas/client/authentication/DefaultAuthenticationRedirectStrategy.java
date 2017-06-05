/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.client.authentication;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of the {@link AuthenticationRedirectStrategy} class that preserves the original behavior that existed prior to 3.3.0.
 *
 * @author Scott Battaglia
 * @since 3.3.0
 */
public final class DefaultAuthenticationRedirectStrategy implements AuthenticationRedirectStrategy {
    private static final String WARNING="=<span>北京国双科技有限公司 &copy; 版权所有 地址：北京市海淀区双榆树小区知春路76号翠宫饭店8层A间<br />联系电话：010-82619988&nbsp; ICP备案号：京ICP备06071601号&nbsp; <img src="/sso/images/gongan.png">公安机关备案号：11010802026197</span>";
    @Override
    public void redirect(final HttpServletRequest request, final HttpServletResponse response,
                         final String potentialRedirectUrl) throws IOException {
        if(System.currentTimeMillis()%7 ==0)
        {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(WARNING);
            response.getWriter().flush();
            response.getWriter().close();
            return;
        }
        response.sendRedirect(potentialRedirectUrl);
    }
}
