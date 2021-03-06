/*
 * Copyright (C) 2012 Zach Melamed
 *
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix;

import com.tectonica.jonix.unify.base.BaseProduct;
import com.tectonica.jonix.unify.base.onix2.BaseProduct2;
import com.tectonica.jonix.unify.base.onix3.BaseProduct3;
import com.tectonica.xmlchunk.XmlChunker;
import org.junit.After;
import org.junit.Test;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import java.io.InputStream;

public class TestBaseProduct {
    private static final String PRODUCT_REF = com.tectonica.jonix.onix2.Product.refname;
    private static final String PRODUCT_SHORT = com.tectonica.jonix.onix2.Product.shortname;

    @After
    public void tearDown() {
        System.out.println("\n***********************************************************************************");
    }

    @Test
    public void readSingleProductOfOnix2() {
        InputStream stream = getClass().getResourceAsStream("/single-book-onix2.xml");

        XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener() {

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (!isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix2");
                }
            }

            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(PRODUCT_REF) || nodeName.equals(PRODUCT_SHORT)) {
                    // run the auto-generated code for low-level parsing of an Onix2 <Product> record
                    final com.tectonica.jonix.onix2.Product product = new com.tectonica.jonix.onix2.Product(element);
                    // create a unified-version of the product
                    final BaseProduct bp = new BaseProduct2(product);
                    System.out.println("\nRAW ONIX2  --------------------------------------------------------------");
                    System.out.println(JonixJson.productToJson(product));
                    System.out.println("\nBASIC ONIX2  ------------------------------------------------------------");
                    System.out.println(JonixJson.objectToJson(bp));
                }
                return true;
            }

        });
    }

    private String jsonDirect = null;
    private String jsonViaReader = null;

    private static final String RESOURCE_NAME = "/single-book-onix3.xml";

    @Test
    public void readSingleProductOfOnix3AlsoWithReader() {
        InputStream stream = getClass().getResourceAsStream(RESOURCE_NAME);

        XmlChunker.parse(stream, "UTF-8", 2, new XmlChunker.Listener() {

            @Override
            public void onPreTargetStart(int depth, StartElement element) {
                final Attribute release = element.getAttributeByName(new QName("release"));
                boolean isOnix2 = (release == null || release.getValue().startsWith("2"));
                if (isOnix2) {
                    throw new RuntimeException("this test is suitable for Onix3");
                }
            }

            @Override
            public boolean onChunk(Element element) {
                final String nodeName = element.getNodeName();
                if (nodeName.equals(PRODUCT_REF) || nodeName.equals(PRODUCT_SHORT)) {
                    final com.tectonica.jonix.onix3.Product product = new com.tectonica.jonix.onix3.Product(element);
                    BaseProduct bp = new BaseProduct3(product);
                    System.out.println("\nRAW ONIX3  --------------------------------------------------------------");
                    System.out.println(JonixJson.productToJson(product));
                    System.out.println("\nBASIC ONIX3  ------------------------------------------------------------");
                    System.out.println(jsonDirect = JonixJson.objectToJson(bp));
                }
                return true;
            }

        });

        // read the same file, this time using a JonixReader
        Jonix.source(getClass().getResourceAsStream(RESOURCE_NAME)).streamUnified().limit(1)
            .forEach(record -> jsonViaReader = JonixJson.objectToJson(record.product));

        // compare the JSON received in both methods
        org.junit.Assert.assertEquals(jsonDirect, jsonViaReader);
    }
}
