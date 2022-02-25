/* 
 * Class to define a state for the programs generating all substrings.
 */

public class CState {
	String prefix;
	String suffix;

	CState(String p, String s) {
		prefix = p;
		suffix = s;
	}

	public String pre() {
		return prefix;
	}

	public String suff() {
		return suffix;
	}

	public String toString() {
		return prefix + ":" + suffix;
	}

}
