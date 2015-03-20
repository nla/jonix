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
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.MeasureUnits;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Measure
{
	public static final String refname = "Measure";
	public static final String shortname = "measure";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public MeasureTypeCode measureTypeCode; // Required
	public Measurement measurement; // Required
	public MeasureUnitCode measureUnitCode; // Required

	public static Measure fromDoc(org.w3c.dom.Element element)
	{
		final Measure x = new Measure();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(MeasureTypeCode.refname) || name.equals(MeasureTypeCode.shortname))
					x.measureTypeCode = MeasureTypeCode.fromDoc(element);
				else if (name.equals(Measurement.refname) || name.equals(Measurement.shortname))
					x.measurement = Measurement.fromDoc(element);
				else if (name.equals(MeasureUnitCode.refname) || name.equals(MeasureUnitCode.shortname))
					x.measureUnitCode = MeasureUnitCode.fromDoc(element);
			}
		});

		return x;
	}

	public MeasureTypes getMeasureTypeCodeValue()
	{
		return (measureTypeCode == null) ? null : measureTypeCode.value;
	}

	public String getMeasurementValue()
	{
		return (measurement == null) ? null : measurement.value;
	}

	public MeasureUnits getMeasureUnitCodeValue()
	{
		return (measureUnitCode == null) ? null : measureUnitCode.value;
	}
}