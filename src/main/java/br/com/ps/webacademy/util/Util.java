package br.com.ps.webacademy.util;

public class Util {

	public static boolean naoNuloENaoVazio(String att) {
		if (att != null && !att.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static void limpaSB(StringBuilder sb) {
		if (sb != null) {
			sb.delete(0, sb.length());
		}
	}

}
