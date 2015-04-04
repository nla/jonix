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

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Conference implements JonixComposite, Serializable
{
	public static final String refname = "Conference";
	public static final String shortname = "conference";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public ConferenceRole conferenceRole; // Optional
	public ConferenceName conferenceName; // Required
	public ConferenceAcronym conferenceAcronym; // Optional
	public ConferenceNumber conferenceNumber; // Optional
	public ConferenceTheme conferenceTheme; // Optional
	public ConferenceDate conferenceDate; // Optional
	public ConferencePlace conferencePlace; // Optional
	public List<ConferenceSponsor> conferenceSponsors; // ZeroOrMore
	public List<Website> websites; // ZeroOrMore

	public Conference()
	{}

	public Conference(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ConferenceRole.refname) || name.equals(ConferenceRole.shortname))
					conferenceRole = new ConferenceRole(element);
				else if (name.equals(ConferenceName.refname) || name.equals(ConferenceName.shortname))
					conferenceName = new ConferenceName(element);
				else if (name.equals(ConferenceAcronym.refname) || name.equals(ConferenceAcronym.shortname))
					conferenceAcronym = new ConferenceAcronym(element);
				else if (name.equals(ConferenceNumber.refname) || name.equals(ConferenceNumber.shortname))
					conferenceNumber = new ConferenceNumber(element);
				else if (name.equals(ConferenceTheme.refname) || name.equals(ConferenceTheme.shortname))
					conferenceTheme = new ConferenceTheme(element);
				else if (name.equals(ConferenceDate.refname) || name.equals(ConferenceDate.shortname))
					conferenceDate = new ConferenceDate(element);
				else if (name.equals(ConferencePlace.refname) || name.equals(ConferencePlace.shortname))
					conferencePlace = new ConferencePlace(element);
				else if (name.equals(ConferenceSponsor.refname) || name.equals(ConferenceSponsor.shortname))
					conferenceSponsors = JPU.addToList(conferenceSponsors, new ConferenceSponsor(element));
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					websites = JPU.addToList(websites, new Website(element));
			}
		});
	}

	public String getConferenceRoleValue()
	{
		return (conferenceRole == null) ? null : conferenceRole.value;
	}

	public String getConferenceNameValue()
	{
		return (conferenceName == null) ? null : conferenceName.value;
	}

	public String getConferenceAcronymValue()
	{
		return (conferenceAcronym == null) ? null : conferenceAcronym.value;
	}

	public String getConferenceNumberValue()
	{
		return (conferenceNumber == null) ? null : conferenceNumber.value;
	}

	public String getConferenceThemeValue()
	{
		return (conferenceTheme == null) ? null : conferenceTheme.value;
	}

	public String getConferenceDateValue()
	{
		return (conferenceDate == null) ? null : conferenceDate.value;
	}

	public String getConferencePlaceValue()
	{
		return (conferencePlace == null) ? null : conferencePlace.value;
	}
}
