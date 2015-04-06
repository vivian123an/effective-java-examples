package org.effectivejava.examples.chapter02.item01;

import java.util.Collections;
import java.util.List;

public class InstanceControlledTest {

	public static void main(String[] args) {
		List list = Collections.EMPTY_LIST;
		
		
		/**
		 * // Suppresses default constructor, ensuring non-instantiability.
		 *   private Collections() {
		 *   }
		 */
		//The constructor Collections() is not visible
		//new Collections();

	}
}
