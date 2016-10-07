
public class fsainterpreter {
	public static void main(String[] args) {
		String fsaFile = args[0];
		String testFile = args[1].substring(1);

		FsaFactory factory = new FsaFactory(fsaFile, testFile);
		factory.run();
	}
}
