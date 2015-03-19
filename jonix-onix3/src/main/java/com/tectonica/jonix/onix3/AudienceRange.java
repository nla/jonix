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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class AudienceRange
{
	public static final String refname = "AudienceRange";
	public static final String shortname = "audiencerange";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public AudienceRangeQualifier audienceRangeQualifier; // Required
	public AudienceRangePrecision audienceRangePrecision; // Optional
	public AudienceRangeValue audienceRangeValue; // Optional

	public static AudienceRange fromDoc(org.w3c.dom.Element element)
	{
		final AudienceRange x = new AudienceRange();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(AudienceRangeQualifier.refname) || name.equals(AudienceRangeQualifier.shortname))
					x.audienceRangeQualifier = AudienceRangeQualifier.fromDoc(element);
				else if (name.equals(AudienceRangePrecision.refname) || name.equals(AudienceRangePrecision.shortname))
					x.audienceRangePrecision = AudienceRangePrecision.fromDoc(element);
				else if (name.equals(AudienceRangeValue.refname) || name.equals(AudienceRangeValue.shortname))
					x.audienceRangeValue = AudienceRangeValue.fromDoc(element);
			}
		});

		return x;
	}

	public AudienceRangeQualifiers getAudienceRangeQualifierValue()
	{
		return (audienceRangeQualifier == null) ? null : audienceRangeQualifier.value;
	}

	public AudienceRangePrecisions getAudienceRangePrecisionValue()
	{
		return (audienceRangePrecision == null) ? null : audienceRangePrecision.value;
	}

	public String getAudienceRangeValueValue()
	{
		return (audienceRangeValue == null) ? null : audienceRangeValue.value;
	}
}
