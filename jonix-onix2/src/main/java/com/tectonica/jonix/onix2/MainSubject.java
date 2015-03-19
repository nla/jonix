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
import com.tectonica.jonix.codelist.MainSubjectSchemeIdentifierCodes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class MainSubject
{
	public static final String refname = "MainSubject";
	public static final String shortname = "mainsubject";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public MainSubjectSchemeIdentifier mainSubjectSchemeIdentifier; // Required
	public SubjectSchemeVersion subjectSchemeVersion; // Optional
	public SubjectCode subjectCode; // Required
	public SubjectHeadingText subjectHeadingText; // Optional

	public static MainSubject fromDoc(org.w3c.dom.Element element)
	{
		final MainSubject x = new MainSubject();

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
				if (name.equals(MainSubjectSchemeIdentifier.refname) || name.equals(MainSubjectSchemeIdentifier.shortname))
					x.mainSubjectSchemeIdentifier = MainSubjectSchemeIdentifier.fromDoc(element);
				else if (name.equals(SubjectSchemeVersion.refname) || name.equals(SubjectSchemeVersion.shortname))
					x.subjectSchemeVersion = SubjectSchemeVersion.fromDoc(element);
				else if (name.equals(SubjectCode.refname) || name.equals(SubjectCode.shortname))
					x.subjectCode = SubjectCode.fromDoc(element);
				else if (name.equals(SubjectHeadingText.refname) || name.equals(SubjectHeadingText.shortname))
					x.subjectHeadingText = SubjectHeadingText.fromDoc(element);
			}
		});

		return x;
	}

	public MainSubjectSchemeIdentifierCodes getMainSubjectSchemeIdentifierValue()
	{
		return (mainSubjectSchemeIdentifier == null) ? null : mainSubjectSchemeIdentifier.value;
	}

	public String getSubjectSchemeVersionValue()
	{
		return (subjectSchemeVersion == null) ? null : subjectSchemeVersion.value;
	}

	public String getSubjectCodeValue()
	{
		return (subjectCode == null) ? null : subjectCode.value;
	}

	public String getSubjectHeadingTextValue()
	{
		return (subjectHeadingText == null) ? null : subjectHeadingText.value;
	}
}
