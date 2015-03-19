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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Imprint
{
	public static final String refname = "Imprint";
	public static final String shortname = "imprint";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public ImprintName imprintName; // Optional
	public NameCodeType nameCodeType; // Required
	public NameCodeTypeName nameCodeTypeName; // Optional
	public NameCodeValue nameCodeValue; // Required

	public static Imprint fromDoc(org.w3c.dom.Element element)
	{
		final Imprint x = new Imprint();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ImprintName.refname) || name.equals(ImprintName.shortname))
					x.imprintName = ImprintName.fromDoc(element);
				else if (name.equals(NameCodeType.refname) || name.equals(NameCodeType.shortname))
					x.nameCodeType = NameCodeType.fromDoc(element);
				else if (name.equals(NameCodeTypeName.refname) || name.equals(NameCodeTypeName.shortname))
					x.nameCodeTypeName = NameCodeTypeName.fromDoc(element);
				else if (name.equals(NameCodeValue.refname) || name.equals(NameCodeValue.shortname))
					x.nameCodeValue = NameCodeValue.fromDoc(element);
			}
		});

		return x;
	}

	public String getImprintNameValue()
	{
		return (imprintName == null) ? null : imprintName.value;
	}

	public NameCodeTypes getNameCodeTypeValue()
	{
		return (nameCodeType == null) ? null : nameCodeType.value;
	}

	public String getNameCodeTypeNameValue()
	{
		return (nameCodeTypeName == null) ? null : nameCodeTypeName.value;
	}

	public String getNameCodeValueValue()
	{
		return (nameCodeValue == null) ? null : nameCodeValue.value;
	}
}
