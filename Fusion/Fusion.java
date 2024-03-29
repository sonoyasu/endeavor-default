import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

class Fusion {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("You must specified 4 args.");
            return;
        }

        String sourceFile = args[0];
        String target = args[1];
        String sosFile = args[2];
        String distFile = args[3];

		Path sourceFilePath = Paths.get(sourceFile);
        Path sosFilePath = Paths.get(sosFile);
        Path distFilePath = Paths.get(distFile);

        String sourceFileContent = "";
        String sosFileContent = "";


        // ファイル読込
		try {
			sourceFileContent = Files.readString(sourceFilePath);
			sosFileContent = Files.readString(sosFilePath);
			// System.out.println(sourceFileContent);
			// System.out.println(sosFileContent);
		} catch(IOException ex) {
			ex.printStackTrace();
		}

        // タイムスタンプ取得
        String dateString = ( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        // 置換文字列の先頭に付与
        sosFileContent = "//////Fused at " + dateString + "\n" + sosFileContent;



        // 置換
        Pattern pattern = Pattern.compile("//////FUSIONSTART\s+" + target +  ".*//////FUSIONEND\s+" + target, Pattern.DOTALL);
        String fusedContent = pattern.matcher(sourceFileContent).replaceAll(sosFileContent);

        //dist書き出し
        try {
            Files.writeString(distFilePath, fusedContent, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}