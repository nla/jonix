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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Extent value</h1><p>The numeric value of the extent specified in &lt;ExtentType&gt;. Optional, and non-repeating.
 * However, either &lt;ExtentValue&gt; or &lt;ExtentValueRoman&gt;, or both, must be present in each occurrence of the
 * &lt;Extent&gt; composite; and it is very strongly recommended that &lt;ExtentValue&gt; should <em>always</em> be
 * included, even when the original product uses Roman numerals.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Numeric, with decimal point where required, as appropriate for the units
 * specified in &lt;ExtentUnit&gt;</td></tr><tr><td>Reference name</td><td>&lt;ExtentValue&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b219&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td>&lt;b219&gt;2.5&lt;/b219&gt;</td></tr></table>
 */
public class ExtentValue implements OnixElement<Double>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ExtentValue";
    public static final String shortname = "b219";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Numeric, with decimal point where required, as appropriate for the units specified in
     * &lt;ExtentUnit&gt;<p> (type: dt.StrictPositiveDecimal)
     */
    public Double value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public Double _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final ExtentValue EMPTY = new ExtentValue();

    public ExtentValue() {
        exists = false;
    }

    public ExtentValue(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsDouble(element);
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
