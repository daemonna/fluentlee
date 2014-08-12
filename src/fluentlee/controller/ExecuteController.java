package fluentlee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class ExecuteController implements Observer {

	/**
	 * detect OS, replace shell values and execute command
	 *
	 * @param params
	 *            command to execute
	 */
	public int executor(String[] params) throws IOException {

		int exitValue;
		String osname = System.getProperty("os.name").toLowerCase();
		String[] cmd = new String[params.length + 2];
		
		switch(osname){
			case "windows":
				cmd[0] = "cmd";
				cmd[1] = "/C";
				break;
			case "mac":
			case "linux":
				cmd[0] = "/bin/bash";
				cmd[1] = "-c";
				break;
			case "unix":
			case "sunos":
			case "z/os":
				cmd[0] = "/bin/sh";
				cmd[1] = "-c";
				break;
		}	
				
		


		for (int ff = 0; ff < params.length; ff++) {
			if (!params[ff].isEmpty()) {
				cmd[ff + 2] = params[ff];
				System.out.println("ADDING: " + Integer.toString(ff + 2)
						+ " - " + ff + " - " + params[ff]);
			}
		}

		// System.out.println("EXECUTOR: ");

		// I call processBuilder.redirectErrorStream(true); before
		// processBuilder.start().
		// SO there should only be one combined output stream. –
		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.redirectErrorStream(true);
		Process p = pb.start();

		// The simplest way is to invoke the shell with the command line as the
		// parameter.
		// After all, it's the shell which is interpreting "|" to mean
		// "pipe the data between two processes".
		// Alternatively, you could launch each process separately, and read
		// from the standard
		// output of "ls -l", writing the data to the standard input of "grep"
		// in your example.

		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		// System.out.printf("Output of running %s is:\n",Arrays.toString(cmd));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		// Wait to get exit value
		try {
			exitValue = p.waitFor();
			// System.out.println("\n\nExit Value is " + exitValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			exitValue = -1;
		}

		// System.out.println("EXECUTOR END: ");
		return exitValue;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
