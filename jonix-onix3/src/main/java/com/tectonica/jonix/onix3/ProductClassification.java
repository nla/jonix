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
import com.tectonica.jonix.codelist.ProductClassificationTypeCodes;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ProductClassification
{
	public static final String refname = "ProductClassification";
	public static final String shortname = "productclassification";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public ProductClassificationType productClassificationType; // Required
	public ProductClassificationCode productClassificationCode; // Required
	public Percent percent; // Optional

	public static ProductClassification fromDoc(org.w3c.dom.Element element)
	{
		final ProductClassification x = new ProductClassification();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ProductClassificationType.refname) || name.equals(ProductClassificationType.shortname))
					x.productClassificationType = ProductClassificationType.fromDoc(element);
				else if (name.equals(ProductClassificationCode.refname) || name.equals(ProductClassificationCode.shortname))
					x.productClassificationCode = ProductClassificationCode.fromDoc(element);
				else if (name.equals(Percent.refname) || name.equals(Percent.shortname))
					x.percent = Percent.fromDoc(element);
			}
		});

		return x;
	}

	public ProductClassificationTypeCodes getProductClassificationTypeValue()
	{
		return (productClassificationType == null) ? null : productClassificationType.value;
	}

	public String getProductClassificationCodeValue()
	{
		return (productClassificationCode == null) ? null : productClassificationCode.value;
	}

	public Double getPercentValue()
	{
		return (percent == null) ? null : percent.value;
	}
}
