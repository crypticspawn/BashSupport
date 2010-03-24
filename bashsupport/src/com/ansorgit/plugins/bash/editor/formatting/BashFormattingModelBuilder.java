/*
 * Copyright 2010 Joachim Ansorg, mail@ansorg-it.com
 * File: BashFormattingModelBuilder.java, Class: BashFormattingModelBuilder
 * Last modified: 2010-03-24
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

package com.ansorgit.plugins.bash.editor.formatting;

import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This code is based on code taken from the Groovy plugin.
 *
 * @author ilyas, jansorg
 */
public class BashFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    public FormattingModel createModel(final PsiElement element, final CodeStyleSettings settings) {
        ASTNode node = element.getNode();
        assert node != null;

        PsiFile containingFile = element.getContainingFile();//.getViewProvider().getPsi(BashFileType.BASH_LANGUAGE);
        //assert containingFile != null : element.getContainingFile();

        ASTNode astNode = containingFile.getNode();
        assert astNode != null;

        return FormattingModelProvider.createFormattingModelForPsiFile(containingFile,
                new BashBlock(astNode, null, Indent.getAbsoluteNoneIndent(), null, settings), settings);
    }

    @Nullable
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
