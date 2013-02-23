package shadows.IDW.utils;

public class NotMyFault extends RuntimeException {
	private String mError;

	public NotMyFault(String var1) {
		this.mError = var1;
	}

	public String toString() {
		return "The "
				+ Registry.name
				+ "-Addon has a Problem.\nIT\'S NOT MY FAULT!!! Below is how to fix it.\n"
				+ this.mError
				+ "\nDO NOT COME TO ME WITH THIS CRASH. YOU CAUSED IT YOURSELF, AND I TOLD YOU HOW TO FIX IT!!!";
	}
}
