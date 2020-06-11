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

import java.util.Arrays;

public abstract sealed class AbstractNode permits Leaf, Node {
    private final String name;

    public static AbstractNode of(String name, AbstractNode... children) {
        if (children.length == 0) {
            return new Leaf(name);
        }
        return new Node(name, Arrays.asList(children));
    }

    AbstractNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
