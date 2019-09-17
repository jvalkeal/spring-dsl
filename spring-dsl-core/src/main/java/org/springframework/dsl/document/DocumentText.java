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

    public DocumentText insert(int index, DocumentText documentText) {
		text = text.insert(index, documentText.getText());
		return this;
	}

	public DocumentText delete(int start, int end) {
		text.delete(start, end);
		return this;
	}

    public DocumentText subtext(int start, int end) {
		text = text.subtext(start, end);
		return this;
	}

	protected Text getText() {
		return text;
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

}
