/*
 * Copyright © 2015 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.finances.domain;

/**
 * Die Art des Wertpapiers.
 * @author Frank W. Rahn
 */
public enum SecurityType {
		stock("Aktie"), fonds("Investmentfonds"), loan("Anleihe"), certificate("Zertifikat"), warrant("Optionsscheine"),
		other("Sonstiges");

	/** Der Name der Art des Wertpapiers. */
	private String name;

	/**
	 * @param name der Name der Art des Wertpapiers
	 */
	private SecurityType(String name) {
		this.name = name;
	}

	/**
	 * @param name der Name der gesuchten Art des Wertpapiers
	 * @return das Suchergebnis oder <code>null</code>
	 */
	public static SecurityType searchText(String name) {
		for (SecurityType s : SecurityType.values()) {
			if (s.name.equals(name)) {
				return s;
			}
		}

		return null;
	}

	/**
	 * @return der Name der Art des Wertpapiers
	 */
	public String getName() {
		return name;
	}

}