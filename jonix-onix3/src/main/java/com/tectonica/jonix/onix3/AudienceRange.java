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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAudienceRange;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Audience range composite</h1><p>An optional and repeatable group of data elements which together describe an
 * audience or readership range for which a product is intended. The composite can carry a single value <em>from</em>,
 * <em>to</em>, or <em>exact</em>, or a pair of values with an explicit <em>from</em> and <em>to</em>. See examples
 * below.</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td>&lt;AudienceRange&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;audiencerange&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class AudienceRange implements OnixDataComposite<JonixAudienceRange>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AudienceRange";
    public static final String shortname = "audiencerange";

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
    public static final AudienceRange EMPTY = new AudienceRange();

    public AudienceRange() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AudienceRange(org.w3c.dom.Element element) {
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
                case AudienceRangeQualifier.refname:
                case AudienceRangeQualifier.shortname:
                    audienceRangeQualifier = new AudienceRangeQualifier(e);
                    break;
                case AudienceRangePrecision.refname:
                case AudienceRangePrecision.shortname:
                    audienceRangePrecisions = JPU.addToList(audienceRangePrecisions, new AudienceRangePrecision(e));
                    break;
                case AudienceRangeValue.refname:
                case AudienceRangeValue.shortname:
                    audienceRangeValues = JPU.addToList(audienceRangeValues, new AudienceRangeValue(e));
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

    private AudienceRangeQualifier audienceRangeQualifier = AudienceRangeQualifier.EMPTY;

    /**
     * (this field is required)
     */
    public AudienceRangeQualifier audienceRangeQualifier() {
        _initialize();
        return audienceRangeQualifier;
    }

    private ListOfOnixElement<AudienceRangePrecision, AudienceRangePrecisions> audienceRangePrecisions =
        ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<AudienceRangePrecision, AudienceRangePrecisions> audienceRangePrecisions() {
        _initialize();
        return audienceRangePrecisions;
    }

    private ListOfOnixElement<AudienceRangeValue, String> audienceRangeValues = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<AudienceRangeValue, String> audienceRangeValues() {
        _initialize();
        return audienceRangeValues;
    }

    @Override
    public JonixAudienceRange asStruct() {
        _initialize();
        JonixAudienceRange struct = new JonixAudienceRange();
        struct.audienceRangePrecisions = audienceRangePrecisions.values();
        struct.audienceRangeQualifier = audienceRangeQualifier.value;
        struct.audienceRangeValues = audienceRangeValues.values();
        return struct;
    }
}
