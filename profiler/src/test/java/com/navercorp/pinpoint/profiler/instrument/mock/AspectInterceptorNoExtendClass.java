/*
 * Copyright 2016 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.profiler.instrument.mock;

import com.navercorp.pinpoint.bootstrap.instrument.aspect.Aspect;
import com.navercorp.pinpoint.bootstrap.instrument.aspect.JointPoint;
import com.navercorp.pinpoint.bootstrap.instrument.aspect.PointCut;
import com.navercorp.pinpoint.common.util.BytesUtils;

import java.util.Map;

/**
 * @author jaehong.kim
 */
@Aspect
public abstract class AspectInterceptorNoExtendClass {

    @PointCut
    public void testVoid() {
        System.out.println("Aspect testVoid()");
        __testVoid();
    }

    @JointPoint
    abstract void __testVoid();

    @PointCut
    public int testInt() {
        System.out.println("Aspect testInt()");
        final int result = __testInt();
        return result;
    }

    @JointPoint
    abstract int __testInt();


    @PointCut
    public String testString() {
        System.out.println("Aspect testString()");
        String s = __testString();
        return s;
    }

    @JointPoint
    abstract String __testString();

    @PointCut
    public int testUtilMethod() {
        System.out.println("Aspect testUtilMethod()");
        int result = __testInt();
        utilMethod();
        return result;
    }

    private String utilMethod() {
        System.out.println("Aspect utilMethod()");
        return "Util";
    }

    @PointCut
    public void testNoTouch() {
        System.out.println("Aspect testNoTouch()");
        __testVoid();
    }

    @PointCut
    public void testInternalMethod() {
        System.out.println("Aspect testInternalMethod()");
        __testVoid();
    }

    @PointCut
    public void testMethodCall() {
        System.out.println("Aspect testMethodCall()");
        BytesUtils.toBytes("test");
        __testMethodCall();
    }

    @JointPoint
    abstract void __testMethodCall();

    @PointCut
    public Map<String, String> testGeneric() {
        System.out.println("Aspect testGeneric()");
        return null;
    }
}