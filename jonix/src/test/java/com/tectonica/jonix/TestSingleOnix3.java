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

import com.tectonica.jonix.onix3.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.StringReader;

public class TestSingleOnix3 {

    private static Document docOf(String xmlResourceName) {
        try (InputStream is = TestSingleOnix3.class.getResourceAsStream(xmlResourceName)) {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            // disable dtd validation
            docBuilder.setEntityResolver((publicId, systemId) -> new InputSource(new StringReader("")));
            return docBuilder.parse(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testViaDOM() {
        final Document doc = docOf("/single-book-onix3.xml");
        final NodeList products = doc.getElementsByTagName("Product");
        for (int i = 0; i < products.getLength(); i++) {
            final Element productElem = (Element) products.item(i);
            final Product product = new Product(productElem);
            System.out.println(JonixJson.productToJson(product));
        }
    }

    @Test
    public void testViaReader() {
        InputStream source = getClass().getResourceAsStream("/single-book-onix3.xml");
        for (JonixRecord record : Jonix.source(source)) {
            System.out.println(JonixJson.productToJson(record.product));
        }
    }
}
