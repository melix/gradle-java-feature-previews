/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.acme.preview.sc;

import org.junit.jupiter.api.Test;

import static com.acme.preview.sc.AbstractNode.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SealedTest {
    @Test void testSealed() {
        AbstractNode root = of("root",
                of("leaf"),
                of("child", of("deep")),
                of("child 2"));
        assertEquals("""
|-┬- root
  |- leaf
  |-┬- child
    |- deep
  |- child 2
""", TreePrinter.printTree(root));
    }

}
