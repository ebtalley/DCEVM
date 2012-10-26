/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

package at.ssw.hotswap.test.body;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import at.ssw.hotswap.HotSwapTool;

/**
 * @author Thomas Wuerthinger
 */
public class RefactorActiveMethodTest {

    // Version 0
    public static class A {

        public int value() {
            HotSwapTool.toVersion(RefactorActiveMethodTest.class, 1);
            return 5;
        }

        public int secondValue() {
            return 1;
        }
    }

    // Version 1
    public static class A___1 {

        public int value() {
            return secondValue() * 2;
        }

        public int secondValue() {
            return 2;
        }
    }

    @Before
    public void setUp() throws Exception {
        HotSwapTool.toVersion(RefactorActiveMethodTest.class, 0);
    }

    @Test
    public void testActiveMethodReplacement() {

        assert HotSwapTool.getCurrentVersion(RefactorActiveMethodTest.class) == 0;

        A a = new A();

        assertEquals(5, a.value());

        assert HotSwapTool.getCurrentVersion(RefactorActiveMethodTest.class) == 1;

        assertEquals(2, a.secondValue());
        assertEquals(4, a.value());
        assertEquals(2, a.secondValue());

        assert HotSwapTool.getCurrentVersion(RefactorActiveMethodTest.class) == 1;

        HotSwapTool.toVersion(RefactorActiveMethodTest.class, 0);

        assertEquals(1, a.secondValue());
        assertEquals(5, a.value());
        assertEquals(4, a.value());

        HotSwapTool.toVersion(RefactorActiveMethodTest.class, 0);

        assertEquals(1, a.secondValue());
    }
}