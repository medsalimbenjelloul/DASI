package exceptions;

import core.Listener;

public class ExistException extends Exception {
	private static final long serialVersionUID = -8588849569439835137L;

	private Listener observer;

	public ExistException(Listener observer) {
		this.observer = observer;
	}

	@Override
	public String toString() {
		return "ObjectExistsException[" + observer.toString() + "]";
	}

}
