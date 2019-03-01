package br.com.ps.webacademy.exception;

@SuppressWarnings("serial")
public class RegraNegocioException extends Exception {

	public RegraNegocioException(String msg) {
		super(msg);
	}

	public RegraNegocioException(String msg, Throwable t) {
		super(msg, t);
	}
}
