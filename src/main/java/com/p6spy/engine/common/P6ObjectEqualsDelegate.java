/*
 * #%L
 * P6Spy
 * %%
 * Copyright (C) 2013 P6Spy
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.p6spy.engine.common;

import com.p6spy.engine.proxy.Delegate;
import com.p6spy.engine.proxy.P6Proxy;

import java.lang.reflect.Method;
import java.sql.Wrapper;

/**
 * Implementation of {@link Object#equals(Object)} for proxy classes.
 */
public class P6ObjectEqualsDelegate implements Delegate {

  @Override
  public Object invoke(final Object proxy, final Object underlying, final Method method, final Object[] args) throws Throwable {
    Object arg = args[0];

    // If the object to pass to the equals method is another P6Spy proxy, then unwrap it first.
    if(arg != null && arg instanceof P6Proxy ) {
      arg = ((P6Proxy)arg).unwrapP6SpyProxy();
    }

    return underlying.equals(arg);
  }
}