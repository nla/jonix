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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.UsageStatuss;
import com.tectonica.jonix.codelist.UsageTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class EpubUsageConstraint
{
	public static final String refname = "EpubUsageConstraint";
	public static final String shortname = "epubusageconstraint";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public EpubUsageType epubUsageType; // Required
	public EpubUsageStatus epubUsageStatus; // Required
	public List<EpubUsageLimit> epubUsageLimits; // ZeroOrMore

	public static EpubUsageConstraint fromDoc(org.w3c.dom.Element element)
	{
		final EpubUsageConstraint x = new EpubUsageConstraint();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(EpubUsageType.refname) || name.equals(EpubUsageType.shortname))
					x.epubUsageType = EpubUsageType.fromDoc(element);
				else if (name.equals(EpubUsageStatus.refname) || name.equals(EpubUsageStatus.shortname))
					x.epubUsageStatus = EpubUsageStatus.fromDoc(element);
				else if (name.equals(EpubUsageLimit.refname) || name.equals(EpubUsageLimit.shortname))
					x.epubUsageLimits = DU.addToList(x.epubUsageLimits, EpubUsageLimit.fromDoc(element));
			}
		});

		return x;
	}

	public UsageTypes getEpubUsageTypeValue()
	{
		return (epubUsageType == null) ? null : epubUsageType.value;
	}

	public UsageStatuss getEpubUsageStatusValue()
	{
		return (epubUsageStatus == null) ? null : epubUsageStatus.value;
	}
}
