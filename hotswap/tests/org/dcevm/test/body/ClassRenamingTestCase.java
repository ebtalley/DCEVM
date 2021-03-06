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
package org.dcevm.test.body;

import org.dcevm.ClassRedefinitionPolicy;
import org.junit.Test;

import static org.dcevm.test.util.HotSwapTestHelper.__toVersion__;
import static org.junit.Assert.assertEquals;

/**
 * @author Kerstin Breiteneder
 * @author Christoph Wimberger
 */
public class ClassRenamingTestCase {

    public static class B {

        public int a() {
            return 1;
        }
    }

    @ClassRedefinitionPolicy(alias = B.class)
    public static class A___1 {

        public int a() {
            return 2;
        }
    }

    @Test
    public void testRenaming() {
        __toVersion__(0);

        B b = new B();
        assertEquals(1, b.a());

        __toVersion__(1);

        assertEquals(2, b.a());

        __toVersion__(0);

        assertEquals(1, b.a());
    }
}
