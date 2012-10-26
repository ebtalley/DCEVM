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

package at.ssw.hotswap.test.structural;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Class redefinition tests that do arbitrary structural changes.
 *
 * TODO: Add a test where redefinition triggers classloading (e.g. because a super type is not yet loaded).
 * 
 * @author Thomas Wuerthinger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
//    RedefineClassClassTest.class,
//    RedefineObjectClassTest.class,
    GeometryScenario.class,
//    HierarchySwapTest.class,
//    InterfaceTest.class,
//    LargeHierarchyTest.class,
//    ThisTypeChange.class,
//    TypeNarrowingHeapTest.class,
//    TypeNarrowingMethodTest.class,
//    TypeNarrowingMethodTest2.class,
//    TypeNarrowingMethodTest3.class
})
public class StructuralTestSuite {
}