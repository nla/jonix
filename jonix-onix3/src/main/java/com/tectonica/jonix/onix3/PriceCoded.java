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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.PriceCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixPriceCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Price coded composite</h1><p>An optional group of data elements to carry a price that is expressed as one of a
 * discrete set of price points, tiers or bands, rather than actual currency amounts. Each occurrence of the
 * &lt;Price&gt; composite must include either a &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite.</p><table
 * border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;PriceCoded&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;pricecoded&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class PriceCoded implements OnixDataCompositeWithKey<JonixPriceCoded, PriceCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceCoded";
    public static final String shortname = "pricecoded";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final PriceCoded EMPTY = new PriceCoded();

    public PriceCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceCoded(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case PriceCodeType.refname:
                case PriceCodeType.shortname:
                    priceCodeType = new PriceCodeType(e);
                    break;
                case PriceCodeTypeName.refname:
                case PriceCodeTypeName.shortname:
                    priceCodeTypeName = new PriceCodeTypeName(e);
                    break;
                case PriceCode.refname:
                case PriceCode.shortname:
                    priceCode = new PriceCode(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private PriceCodeType priceCodeType = PriceCodeType.EMPTY;

    /**
     * (this field is required)
     */
    public PriceCodeType priceCodeType() {
        _initialize();
        return priceCodeType;
    }

    private PriceCodeTypeName priceCodeTypeName = PriceCodeTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public PriceCodeTypeName priceCodeTypeName() {
        _initialize();
        return priceCodeTypeName;
    }

    private PriceCode priceCode = PriceCode.EMPTY;

    /**
     * (this field is required)
     */
    public PriceCode priceCode() {
        _initialize();
        return priceCode;
    }

    @Override
    public JonixPriceCoded asStruct() {
        _initialize();
        JonixPriceCoded struct = new JonixPriceCoded();
        struct.priceCodeType = priceCodeType.value;
        struct.priceCodeTypeName = priceCodeTypeName.value;
        struct.priceCode = priceCode.value;
        return struct;
    }

    @Override
    public PriceCodeTypes structKey() {
        return priceCodeType().value;
    }
}
