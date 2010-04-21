/*
 * Copyright 2010 Joachim Ansorg, mail@ansorg-it.com
 * File: ParenExpr.java, Class: ParenExpr
 * Last modified: 2010-04-17
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

package com.ansorgit.plugins.bash.lang.parser.arithmetic;

import com.ansorgit.plugins.bash.lang.parser.BashPsiBuilder;
import com.ansorgit.plugins.bash.lang.parser.util.ParserUtil;
import com.intellij.lang.PsiBuilder;

/**
 * Parses an optional parantheses expression. If not found it delegates to another function.
 * <p/>
 * User: jansorg
 * Date: Feb 6, 2010
 * Time: 10:21:56 PM
 */
class ParenExpr implements ArithmeticParsingFunction {
    private final ArithmeticParsingFunction delegate;

    public static ArithmeticParsingFunction delegate(ArithmeticParsingFunction delegate) {
        return new ParenExpr(delegate);
    }

    public ParenExpr(ArithmeticParsingFunction delegate) {
        this.delegate = delegate;
    }

    public boolean isValid(BashPsiBuilder builder) {
        return builder.getTokenType() == LEFT_PAREN || delegate.isValid(builder);
    }

    public boolean parse(BashPsiBuilder builder) {
        PsiBuilder.Marker marker = builder.mark();
        if (ParserUtil.conditionalRead(builder, LEFT_PAREN)) {
            ArithmeticExprParser.instance.parse(builder);
            boolean ok = ParserUtil.conditionalRead(builder, RIGHT_PAREN);

            if (ok) {
                marker.done(ARITH_PARENS_ELEMENT);
            } else {
                marker.drop();
            }

            //try partial parsing for the remaining tokens, we might have an operator as current token
            return delegate.isValidPartial(builder) ? delegate.partialParsing(builder) : ok;
        } else {
            marker.drop();
        }

        return delegate.parse(builder);
    }

    public boolean partialParsing(BashPsiBuilder builder) {
        return delegate.partialParsing(builder);
    }

    public boolean isValidPartial(BashPsiBuilder builder) {
        return delegate.isValidPartial(builder);
    }
}