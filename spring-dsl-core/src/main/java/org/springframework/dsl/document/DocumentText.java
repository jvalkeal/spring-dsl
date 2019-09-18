/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.dsl.document;

import javolution.text.Text;

/**
 * Wrapping {@code javolution} api to hide it from a user and adds other
 * convenient methods.
 *
 * @author Janne Valkealahti
 *
 */
public class DocumentText implements CharSequence {

	private Text text;

	public DocumentText(String text) {
		this.text = new Text(text);
	}

	public DocumentText(Text text) {
		this.text = text;
	}

	protected static DocumentText from(Text text) {
		return new DocumentText(text);
	}

    public DocumentText insert(int index, DocumentText documentText) {
		return from(text.insert(index, documentText.getText()));
	}

	public DocumentText delete(int start, int end) {
		return from(text.delete(start, end));
	}

    public DocumentText subtext(int start, int end) {
		return from(text.subtext(start, end));
	}

    public DocumentText substring(int start, int end) {
		return from(text.subtext(start, end));
	}

	protected Text getText() {
		return text;
	}

	public DocumentText[] splitFirst(char c) {
		int i = text.indexOf(c);
		if (i >= 0) {
			return new DocumentText[] { from(text.subtext(0, i)), from(text.subtext(i + 1, text.length())) };
		} else {
			return new DocumentText[] { from(text) };
		}
	}

	@Override
	public char charAt(int index) {
		return this.text.charAt(index);
	}

	@Override
	public int length() {
		return this.text.length();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return this.text.subSequence(start, end);
	}

	@Override
	public String toString() {
		return this.text.toString();
	}

}
