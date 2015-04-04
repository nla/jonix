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

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.JonixElement;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextScriptCodeIso15924s;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Subtitle implements JonixElement, Serializable
{
	public static final String refname = "Subtitle";
	public static final String shortname = "b029";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;
	public String collationkey;
	public LanguageCodeIso6392Bs language;
	public TextScriptCodeIso15924s textscript;
	public TextCaseFlags textcase;

	public String value; // dt.NonEmptyString

	public Subtitle()
	{}

	public Subtitle(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");
		this.collationkey = JPU.getAttribute(element, "collationkey");
		this.language = LanguageCodeIso6392Bs.byValue(JPU.getAttribute(element, "language"));
		this.textscript = TextScriptCodeIso15924s.byValue(JPU.getAttribute(element, "textscript"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));

		value = JPU.getContentAsString(element);
	}
}
