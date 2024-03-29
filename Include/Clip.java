import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Clip {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("You must specified 3 args.");
            return;
        }

        String source = args[0];
        String target = args[1];
        String sosfile = args[2];

		Path sourceFilePath = Paths.get(source);
        Path sosFilePath = Paths.get(sosfile);

        String sourceFileContent = "";

        // ファイル読込
		try {
			sourceFileContent = Files.readString(sourceFilePath);
		} catch(IOException ex) {
			ex.printStackTrace();
		}

        // 抜き出し
        Pattern pattern = Pattern.compile("(\s+?//////FUSIONSTART\s+" + target +  ".*//////FUSIONEND\s+" + target + ")", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sourceFileContent);

        String clippedContent = "";
        if(matcher.find()) {
            clippedContent = matcher.group(1).toString();
        } else {
            System.out.println("not matches");            
        }

        //SOS書き出し

        try {
            Files.writeString(sosFilePath, clippedContent, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}