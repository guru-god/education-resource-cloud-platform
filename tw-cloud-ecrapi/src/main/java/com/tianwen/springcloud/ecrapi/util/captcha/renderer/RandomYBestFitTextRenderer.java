/*
 * Copyright 2018 Jim Liu.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * By the way, this Soft can only by education, can not be used in commercial products. All right be reserved.
 */
package com.tianwen.springcloud.ecrapi.util.captcha.renderer;

import java.util.Random;

public class RandomYBestFitTextRenderer extends AbstractTextRenderer {

	@Override
	protected void arrangeCharacters(int width, int height, TextString ts) {
		double widthRemaining = (width - ts.getWidth() - leftMargin - rightMargin) / ts.getCharacters().size();
		double vmiddle = (double) height / 2L;
		double x = leftMargin + widthRemaining / 2;
		Random r = new Random();
		height -= topMargin + bottomMargin;
		for (TextCharacter tc : ts.getCharacters()) {
			double heightRemaining = height - tc.getHeight();
			double y = vmiddle + 0.35 * tc.getAscent() + (1 - 2 * r.nextDouble()) * heightRemaining;
			tc.setX(x);
			tc.setY(y);
			x += tc.getWidth() + widthRemaining;
		}
	}

}
