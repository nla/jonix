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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.ResourceFeatureTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ResourceFeature
{
	public static final String refname = "ResourceFeature";
	public static final String shortname = "resourcefeature";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ResourceFeatureType resourceFeatureType; // Required
	public FeatureValue featureValue; // Optional
	public List<FeatureNote> featureNotes; // ZeroOrMore

	public static ResourceFeature fromDoc(org.w3c.dom.Element element)
	{
		final ResourceFeature x = new ResourceFeature();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ResourceFeatureType.refname) || name.equals(ResourceFeatureType.shortname))
					x.resourceFeatureType = ResourceFeatureType.fromDoc(element);
				else if (name.equals(FeatureValue.refname) || name.equals(FeatureValue.shortname))
					x.featureValue = FeatureValue.fromDoc(element);
				else if (name.equals(FeatureNote.refname) || name.equals(FeatureNote.shortname))
					x.featureNotes = DU.addToList(x.featureNotes, FeatureNote.fromDoc(element));
			}
		});

		return x;
	}

	public ResourceFeatureTypes getResourceFeatureTypeValue()
	{
		return (resourceFeatureType == null) ? null : resourceFeatureType.value;
	}

	public String getFeatureValueValue()
	{
		return (featureValue == null) ? null : featureValue.value;
	}

	public List<String> getFeatureNoteValues()
	{
		if (featureNotes != null)
		{
			List<String> list = new ArrayList<>();
			for (FeatureNote i : featureNotes)
				list.add(i.value);
			return list;
		}
		return null;
	}
}