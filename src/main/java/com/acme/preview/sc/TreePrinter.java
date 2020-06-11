/*
 * Copyright 2003-2012 the original author or authors.
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
package com.acme.preview.sc;

public class TreePrinter {
    static String printTree(AbstractNode root) {
        StringBuilder sb = new StringBuilder();
        printTree(root, sb, 0);
        return sb.toString();
    }

    private static void printTree(AbstractNode node, StringBuilder sb, int depth) {
        sb.append("  ".repeat(Math.max(0, depth)));
        // In the future this will become a switch, pattern matching FTW!
        if (node instanceof Leaf) {
            sb.append("|- ");
        } else if (node instanceof Node) {
            sb.append("|-┬- ");
        }
        sb.append(node.getName()).append("\n");
        if (node instanceof Node) {
            for (AbstractNode child : ((Node) node).getChildren()) {
                printTree(child, sb, depth + 1);
            }
        }
    }
}
