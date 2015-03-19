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

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public class Imprint implements Serializable
{
	public final String imprintName;

	public Imprint(String imprintName)
	{
		this.imprintName = imprintName;
	}

	@Override
	public String toString()
	{
		return String.format("Imprint: %s", imprintName);
	}

	public static List<Imprint> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.imprints != null)
		{
			List<Imprint> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Imprint i : product.imprints)
			{
				// TODO: we should at least read one required field (unlike ImprintName)
				final String imprintNameValue = i.getImprintNameValue();
				if (imprintNameValue != null)
					result.add(new Imprint(imprintNameValue));
			}
			return result;
		}
		return Collections.emptyList();
	}
}