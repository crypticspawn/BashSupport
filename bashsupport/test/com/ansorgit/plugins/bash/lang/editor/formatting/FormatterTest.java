/*
 * Copyright 2009 Joachim Ansorg, mail@ansorg-it.com
 * File: FormatterTest.java, Class: FormatterTest
 * Last modified: 2010-02-10
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.editor.formatting;

import com.ansorgit.plugins.bash.lang.base.BashFormatterTestCase;
import com.ansorgit.plugins.bash.lang.base.TestUtils;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.junit.Ignore;

import java.util.List;

/**
 * Test suite for static formatting. Compares two files:
 * before and after formatting
 * <p/>
 * (Based on the code from the GroovyPlugin).
 *
 * @author Ilya.Sergey, Joachim Ansorg
 */
@Ignore
public class FormatterTest extends BashFormatterTestCase {

    @Override
    protected String getBasePath() {
        return "/home/jansorg/Projekte/JavaProjekte/BashSupport/testdata/formatter/";
    }

    protected void setUp() throws Exception {
        super.setUp();
        myTempSettings.CLASS_BRACE_STYLE = CodeStyleSettings.END_OF_LINE;
        myTempSettings.METHOD_BRACE_STYLE = CodeStyleSettings.END_OF_LINE;
        myTempSettings.BRACE_STYLE = CodeStyleSettings.END_OF_LINE;
    }

    public void testCommand() throws Throwable {
        doTest();
    }

    public void testCommandWithParams() throws Throwable {
        doTest();
    }

    public void testFunction() throws Throwable {
        doTest();
    }

    public void testNestedBlocks() throws Throwable {
        doTest();
    }

    public void testStrings() throws Throwable {
        doTest();
    }

    public void testIfThenElse() throws Throwable {
        doTest();
    }

    public void testConditionalCommand() throws Throwable {
        doTest();
    }

    public void testBracketKeyword() throws Throwable {
        doTest();
    }

    public void testVariables() throws Throwable {
        doTest();
    }

    public void testCase() throws Throwable {
        doTest();
    }

    public void testBackticks() throws Throwable {
        doTest();
    }

    public void testFullTest() throws Throwable {
        doTest();
    }

    public void testHeredoc() throws Throwable {
        doTest();
    }

    public void doTest() throws Throwable {
        final List<String> data = TestUtils.readInput(getBasePath() + getTestName(true) + ".test");
        checkFormatting(data.get(0), data.get(1));
    }
}
